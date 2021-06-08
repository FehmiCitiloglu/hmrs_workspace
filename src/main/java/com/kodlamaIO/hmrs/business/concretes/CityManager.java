package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIO.hmrs.business.abstracts.CityService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.CityDao;
import com.kodlamaIO.hmrs.entities.concretes.City;


@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	
	
	
	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Cities are listed");
	}

	@Override
	public Result add(City data) {
		this.cityDao.save(data);
		return new SuccessDataResult("City is added");
	}

}
