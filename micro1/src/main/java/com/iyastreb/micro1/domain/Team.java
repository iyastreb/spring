package com.iyastreb.micro1.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Team {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String address;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="teamId")
	private Set<Player> players;
	
	public Team() {
	}
	
	public Team(String name, String address, Set<Player> players) {
		this.name = name;
		this.address = address;
		this.players = players;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}
