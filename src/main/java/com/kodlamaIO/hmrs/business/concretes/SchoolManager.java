package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaIO.hmrs.business.abstracts.SchoolService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.SchoolDao;
import com.kodlamaIO.hmrs.entities.concretes.School;




@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}
	
	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessDataResult("School is added");
	}

	@Override
	public DataResult<List<School>> orderByDateDesc() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.orderByDateDesc());
		
	}

}
