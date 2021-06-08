package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.ProgrammingLanguageService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingALnguageController")
public class ProgrammingLanguageController implements BaseController<ProgrammingLanguage>{

	private ProgrammingLanguageService programmingLanguageService;
	
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@Override
	@GetMapping(value = "/getAll")
	public DataResult<List<ProgrammingLanguage>> getAll() {
		
		return this.programmingLanguageService.getAll();
	}

	@Override
	@PostMapping(value = "/add")
	public Result add(@RequestBody ProgrammingLanguage programmingLanguage) {
		
		return this.programmingLanguageService.add(programmingLanguage);
	}
	
}
