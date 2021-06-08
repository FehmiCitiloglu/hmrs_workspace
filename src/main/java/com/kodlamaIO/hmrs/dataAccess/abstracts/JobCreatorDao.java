package com.kodlamaIO.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaIO.hmrs.entities.concretes.JobCreator;

public interface JobCreatorDao extends JpaRepository<JobCreator, Integer>{

}
