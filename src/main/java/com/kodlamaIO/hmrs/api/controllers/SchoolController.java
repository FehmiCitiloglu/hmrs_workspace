package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.SchoolService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolController implements BaseController<School>{

	private SchoolService schoolService;
	@Autowired
	public SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getAll")
	@Override
	public DataResult<List<School>> getAll() {
		return this.schoolService.getAll();
	}

	@Override
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		
		return this.schoolService.add(school);
	}
	@GetMapping("/orderByDateDesc")
	public DataResult<List<School>> orderByDateDesc(){
		return this.schoolService.orderByDateDesc();
	}

}
