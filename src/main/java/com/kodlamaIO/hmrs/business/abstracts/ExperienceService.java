package com.kodlamaIO.hmrs.business.abstracts;

import java.util.List;

import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.entities.concretes.Experience;
import com.kodlamaIO.hmrs.entities.concretes.School;

public interface ExperienceService extends BaseService<Experience>{
	DataResult<List<Experience>> orderByQuitDateDesc();
}
