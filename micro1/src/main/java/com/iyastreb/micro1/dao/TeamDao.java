package com.iyastreb.micro1.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.iyastreb.micro1.domain.Team;

@RestResource(path="teams", rel="teams")
public interface TeamDao extends CrudRepository<Team, Long>{

	List<Team> findAll();
	
	Team findByName(String name);
}
