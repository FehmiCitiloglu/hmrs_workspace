package com.kodlamaIO.hmrs.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.kodlamaIO.hmrs.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	@Query("From JobPosting where isOpen = true order by releaseDate")
	List<JobPosting> orderByDate();
	
	@Query("From JobPosting where isOpen = true order by releaseDate desc")
	List<JobPosting> orderByDateDesc();
	
	List<JobPosting> getByJobCreator_CompanyName(String companyName);
	
	@Transactional
	@Modifying
	@Query("update JobPosting set isOpen=:isOpen where postId=:postId")
	void updateIsOpen(int postId, boolean isOpen);
}
