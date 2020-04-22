package com.awin.jobportal.service;

import java.io.IOException;

import com.awin.jobportal.dto.FormDto;

public interface FormService {
	void registerApplication(FormDto formDto) throws IOException;
}
