package com.kodlamaIO.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kodlamaIO.hmrs.entities.concretes.JobSeekers;

public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer>{

}
