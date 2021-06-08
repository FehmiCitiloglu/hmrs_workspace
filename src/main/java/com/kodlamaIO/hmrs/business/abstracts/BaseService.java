package com.kodlamaIO.hmrs.business.abstracts;

import java.util.List;



import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;



public interface BaseService<T> {
	DataResult<List<T>>  getAll();
	
	Result add(T data);
}
