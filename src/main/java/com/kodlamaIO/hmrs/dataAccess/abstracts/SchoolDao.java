package com.kodlamaIO.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.kodlamaIO.hmrs.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	
	@Query("From School where isFinish = true order by finishDate desc")
	List<School> orderByDateDesc();
}
