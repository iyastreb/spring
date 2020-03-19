package com.iyastreb.micro1.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.iyastreb.micro1.domain.Player;

@RestResource(path="players", rel="players")
public interface PlayerDao extends CrudRepository<Player, Long>{

}
