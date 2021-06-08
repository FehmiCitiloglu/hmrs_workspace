package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIO.hmrs.business.abstracts.JobSeekersService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.JobSeekersDao;
import com.kodlamaIO.hmrs.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService{

	private JobSeekersDao jobSeekersDao;

	@Autowired
	 public JobSeekersManager(JobSeekersDao jobSeekersDao) {
		this.jobSeekersDao = jobSeekersDao;
	}
	
	@Override
	public DataResult<List<JobSeekers>> getAll() {
		
		return new SuccessDataResult<List<JobSeekers>>(this.jobSeekersDao.findAll(), "Job seekers listed");
	}
	
	@Override
	public Result add(JobSeekers data) {
		this.jobSeekersDao.save(data);
		return new SuccessDataResult("Jobseeker added");
	}


}
