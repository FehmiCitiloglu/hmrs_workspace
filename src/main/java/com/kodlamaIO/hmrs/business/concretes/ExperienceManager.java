package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIO.hmrs.business.abstracts.ExperienceService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.ExperienceDao;
import com.kodlamaIO.hmrs.entities.concretes.Experience;
import com.kodlamaIO.hmrs.entities.concretes.School;

import net.bytebuddy.asm.Advice.This;

@Service
public class ExperienceManager implements ExperienceService{
	
	private ExperienceDao experienceDao;
	
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
	}

	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessDataResult("Experince is added");
	}

	@Override
	public DataResult<List<Experience>> orderByQuitDateDesc() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Experience>>(this.experienceDao.orderByQuitDateDesc(), "Experiences are listed by date");
	}

}
