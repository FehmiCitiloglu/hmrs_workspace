package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.ExperienceService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.entities.concretes.Experience;
import com.kodlamaIO.hmrs.entities.concretes.School;

@RestController
@RequestMapping("/api/experineces")
public class ExperienceController implements BaseController<Experience>{

	private ExperienceService experienceService;
	
	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@Override
	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll() {
		
		return this.experienceService.getAll();
	}

	@PostMapping("/add")
	@Override
	public Result add(@RequestBody Experience experience) {
		
		return this.experienceService.add(experience);
	}
	
	@GetMapping("/orderByQuitDateDesc")
	public DataResult<List<Experience>> orderByQuitDateDesc() {
		return this.experienceService.orderByQuitDateDesc();
	}
}
