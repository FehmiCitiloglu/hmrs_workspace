package com.kodlamaIO.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaIO.hmrs.business.abstracts.UsersService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController implements BaseController<User>{
	
	private UsersService userService;
	
	@Autowired
	public UsersController(UsersService usersService) {
		this.userService = usersService;
	}
	
	@Override
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return this.userService.getAll();
	}

	@Override
	@PostMapping("/add")
	public Result add(User user) {
	
		return this.userService.add(user);
	}

}
