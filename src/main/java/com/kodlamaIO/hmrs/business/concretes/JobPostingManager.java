package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodlamaIO.hmrs.business.abstracts.JobPostingService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.JobPostingDao;
import com.kodlamaIO.hmrs.entities.concretes.JobPosting;

import net.bytebuddy.asm.Advice.This;


@Service
public class JobPostingManager implements JobPostingService{
	
	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}
	
	@Override
	public DataResult<List<JobPosting>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), "Job posts is listed");
	}

	@Override
	public Result add(JobPosting data) {
		this.jobPostingDao.save(data);
		return new SuccessDataResult("job posting is added");
	}

	@Override
	public DataResult<List<JobPosting>> orderByDate() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.orderByDate(),"Job posts are listed  by release date");
	}
	
	@Override
	public DataResult<List<JobPosting>> orderByDateDesc() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.orderByDateDesc(),"Job posts are listed  by release date (descend)");
	}

	@Override
	public DataResult<List<JobPosting>> getByJobCreator_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByJobCreator_CompanyName(companyName), "Jop posts are listed by company name");
	}

	@Override
	public void updateIsOpen(int postId, boolean isOpen) {
		 this.jobPostingDao.updateIsOpen(postId, isOpen);
	}

}
