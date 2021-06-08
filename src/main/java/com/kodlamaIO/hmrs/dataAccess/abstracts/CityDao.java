package com.kodlamaIO.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaIO.hmrs.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
