package com.awin.jobportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "application")
@SequenceGenerator(name = "mobile_ad_id_seq", sequenceName = "mobile_ad_id_seq", allocationSize = 1)
@Getter
@Setter
public class CandidateApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mobile_ad_id_seq")
	@Column(updatable = false, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String jobTitle;
	@Column(nullable = false)
	private String source;
	@Column(nullable = false)
	private String fileName;

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}

	/*
	 * Since we cannot rely on a natural identifier for equality checks, we need to use the entity identifier 
	 * instead for the equals method. However, you need to do it properly so that equality is consistent 
	 * across all entity state transitions, which is also the reason why the hashCode has to be a constant value.
	 */
	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateApplication other = (CandidateApplication) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
