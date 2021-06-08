package com.kodlamaIO.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaIO.hmrs.entities.concretes.Experience;
import com.kodlamaIO.hmrs.entities.concretes.School;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	@Query("From Experience  order by quitDate desc")
	List<Experience> orderByQuitDateDesc();
}
