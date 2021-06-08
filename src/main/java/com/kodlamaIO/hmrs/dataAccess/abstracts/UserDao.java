package com.kodlamaIO.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaIO.hmrs.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
