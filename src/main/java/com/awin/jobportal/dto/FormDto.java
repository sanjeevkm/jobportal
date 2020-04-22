package com.awin.jobportal.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormDto {
	@NotNull(message = "{validation.cvform.fname}")
	private String firstName;
	@NotNull(message = "{validation.cvform.lname}")
	private String lastName;
	@NotNull(message = "{validation.cvform.email}")
	@Email(message = "{validation.cvform.invalidemail}")
	private String email;
	@NotNull(message = "{validation.cvform.jobtitle}")
	private String jobTitle;
	@NotNull(message = "{validation.cvform.source}")
	private String source;
	@NotNull(message = "{validation.cvform.cv}")
	private MultipartFile file;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
