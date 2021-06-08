package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.JobCreatorService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.entities.concretes.JobCreator;

@RestController
@RequestMapping("/api/jobcreators")
public class JobCreatorController implements BaseController<JobCreator>{

	private JobCreatorService jobCreatorService;
	
	@Autowired
	public JobCreatorController(JobCreatorService jobCreatorService) {
		this.jobCreatorService = jobCreatorService;
	}
	@GetMapping("/getall")
	public DataResult<List<JobCreator>> getAll(){
		return this.jobCreatorService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobCreator jobCreator) {
		return this.jobCreatorService.add(jobCreator);
	}
}
