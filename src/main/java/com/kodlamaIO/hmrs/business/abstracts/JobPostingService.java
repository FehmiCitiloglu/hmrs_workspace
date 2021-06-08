package com.kodlamaIO.hmrs.business.abstracts;

import java.util.List;

import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.entities.concretes.JobPosting;

public interface JobPostingService extends BaseService<JobPosting>{
	
	DataResult<List<JobPosting>> orderByDate();
	
	DataResult<List<JobPosting>> orderByDateDesc();
	
	DataResult<List<JobPosting>> getByJobCreator_CompanyName(String companyName);

	void updateIsOpen(int postId, boolean isOpen);
}
