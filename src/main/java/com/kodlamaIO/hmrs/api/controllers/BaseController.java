package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;

@RequestMapping("/{}")
public interface BaseController<T> {
	@GetMapping("/getAll")
	public DataResult<List<T>> getAll();
	@PostMapping("/add")
	public Result add(@RequestBody T data);
}
