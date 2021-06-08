package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIO.hmrs.business.abstracts.JobCreatorService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.JobCreatorDao;
import com.kodlamaIO.hmrs.entities.concretes.JobCreator;

@Service
public class JobCreatorManager implements JobCreatorService{

	private JobCreatorDao jobCreatorDao;
	
	@Autowired
	public JobCreatorManager(JobCreatorDao jobCreatorDao) {
		this.jobCreatorDao = jobCreatorDao;
	}
	
	@Override
	public DataResult<List<JobCreator>> getAll() {
		
		return new SuccessDataResult<List<JobCreator>>(this.jobCreatorDao.findAll(), "Job creators is listed");
	}

	@Override
	public Result add(JobCreator data) {
		this.jobCreatorDao.save(data);
		return new SuccessDataResult("Job creator added");
	}

}
