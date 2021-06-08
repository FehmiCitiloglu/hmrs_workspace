package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.CityService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
public class CityController implements BaseController<City>{
	
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@Override
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll() {
		
		return this.cityService.getAll();
	}

	@Override
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		
		return this.cityService.add(city);
	}

}
