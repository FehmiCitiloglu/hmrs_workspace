package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.JobPostingService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.entities.concretes.JobPosting;


@RestController
@RequestMapping("/api/jobPosting")
public class JobPostingController implements BaseController<JobPosting>{
	
	private JobPostingService jobPostingService;
	
	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService; 
	}
	
	@Override
	@GetMapping("/getAll")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@Override
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting data) {
		return this.jobPostingService.add(data);
	}
	
	@GetMapping("/orderByDate")
	public  DataResult<List<JobPosting>> orderByDate() {
		return this.jobPostingService.orderByDate();
	}
	
	@GetMapping("/orderByDateDesc")
	public  DataResult<List<JobPosting>> orderByDateDesc() {
		return this.jobPostingService.orderByDateDesc();
	}
	
	@GetMapping("/getByJobCreator_CompanyName")
	public  DataResult<List<JobPosting>> getByJobCreator_CompanyName(String companyName) {
		return this.jobPostingService.getByJobCreator_CompanyName(companyName);
	}
	
	@PostMapping("/updateIdOpen")
	public  void updateIsOpen(@RequestParam int postId, @RequestParam boolean isOpen) {
		 this.jobPostingService.updateIsOpen(postId, isOpen);
	}
	
	
}
