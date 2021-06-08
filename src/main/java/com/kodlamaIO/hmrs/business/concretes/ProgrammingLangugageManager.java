package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIO.hmrs.business.abstracts.ProgrammingLanguageService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.ProgrammingLanguageDao;
import com.kodlamaIO.hmrs.entities.concretes.ProgrammingLanguage;



@Service
public class ProgrammingLangugageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageDao programminglanguageDao;
	
	@Autowired
	public ProgrammingLangugageManager(ProgrammingLanguageDao programminglanguageDao) {
		this.programminglanguageDao = programminglanguageDao;
	}
	
	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		
		return new SuccessDataResult<List<ProgrammingLanguage>>(this.programminglanguageDao.findAll(), "Programming languages are listed");
	}

	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
		this.programminglanguageDao.save(programmingLanguage);
		return new SuccessDataResult("Programming language is added");
	}

}
