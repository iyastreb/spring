package com.iyastreb.micro1.domain;

import java.util.Set;

public class Team {
	private String name;
	private String address;
	private Set<Player> players;
	
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
