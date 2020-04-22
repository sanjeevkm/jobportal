package com.awin.jobportal.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.awin.jobportal.dto.FormDto;
import com.awin.jobportal.model.CandidateApplication;
import com.awin.jobportal.repository.CustomerApplicationRepository;

@Service
public class FormServiceImpl implements FormService {
	@Autowired
	private CustomerApplicationRepository customerApplicationRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerApplication(FormDto formDto) throws IOException {
		CandidateApplication entity = new CandidateApplication();

		entity.setFirstName(formDto.getFirstName());
		entity.setLastName(formDto.getLastName());
		entity.setEmail(formDto.getEmail());
		entity.setJobTitle(formDto.getJobTitle());
		entity.setSource(formDto.getSource());
		entity.setFileName(formDto.getFile().getOriginalFilename());

		customerApplicationRepository.save(entity);
	}
}
