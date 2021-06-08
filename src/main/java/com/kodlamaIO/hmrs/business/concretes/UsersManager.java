package com.kodlamaIO.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaIO.hmrs.business.abstracts.UsersService;
import com.kodlamaIO.hmrs.core.utilities.results.DataResult;
import com.kodlamaIO.hmrs.core.utilities.results.Result;
import com.kodlamaIO.hmrs.core.utilities.results.SuccessDataResult;
import com.kodlamaIO.hmrs.dataAccess.abstracts.UserDao;
import com.kodlamaIO.hmrs.entities.concretes.User;


@Service
public class UsersManager implements UsersService{
	
	private UserDao userDao;
	
	@Autowired
	public UsersManager(UserDao usersDao) {
		this.userDao = usersDao;
	}
	
	
	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users are listed");
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessDataResult("User is added");
	}

}
