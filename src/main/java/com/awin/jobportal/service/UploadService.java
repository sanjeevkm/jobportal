package com.awin.jobportal.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	void uploadFile(MultipartFile file) throws IOException;
}
