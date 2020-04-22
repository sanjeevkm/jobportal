package com.awin.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awin.jobportal.model.CandidateApplication;

/*
 * Repository to handle CRUD operation for CandidateApplication
 */
@Repository
public interface CustomerApplicationRepository extends JpaRepository<CandidateApplication, Long> {
}
