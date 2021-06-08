package com.kodlamaIO.hmrs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.JobPositionsService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.entities.concretes.JobPositions;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController implements BaseController<JobPositions>{
	
	private JobPositionsService jobPositionsService;
	
	@Autowired
	public JobPositionsController(JobPositionsService jobPositionsService) {
		super();
		this.jobPositionsService = jobPositionsService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPositions>>  getAll(){
		return this.jobPositionsService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobPositions jobPositions) {
		return this.jobPositionsService.add(jobPositions);
	}
}
