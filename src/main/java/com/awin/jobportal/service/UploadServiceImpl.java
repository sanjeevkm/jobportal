package com.awin.jobportal.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {
	@Value("${java.io.tmpdir}")
	private String dirLocation;

	@Override
	public void uploadFile(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if (file.isEmpty()) {
			throw new IOException("Failed to store empty file " + filename);
		}
		if (filename.contains("..")) {
			// This is a security check
			throw new IOException("Cannot store file with relative path outside current directory " + filename);
		}
		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, Paths.get(dirLocation).resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		}
	}
}
