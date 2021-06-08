package com.kodlamaIO.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodlamaIO.hmrs.entities.dtos.CurriculumVitae;

public interface CurriculumViteaDao extends JpaRepository<CurriculumVitae, Integer> {

	@Query("Select new com.kodlamaIO.hmrs.entities.dtos.CurriculumVitae ()")
	List<CurriculumVitae> getCirCurriculumVitaes();
}
