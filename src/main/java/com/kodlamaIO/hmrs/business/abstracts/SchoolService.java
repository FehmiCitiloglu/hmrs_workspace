package com.kodlamaIO.hmrs.business.abstracts;

import java.util.List;

import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.entities.concretes.School;

public interface SchoolService extends BaseService<School>{
	
	DataResult<List<School>>  orderByDateDesc();
}
