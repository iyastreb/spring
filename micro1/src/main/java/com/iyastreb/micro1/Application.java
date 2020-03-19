package com.iyastreb.micro1;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.iyastreb.micro1.dao.TeamDao;
import com.iyastreb.micro1.domain.Player;
import com.iyastreb.micro1.domain.Team;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	@Autowired
	private TeamDao teamDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player("Ilia", "forward"));
		players.add(new Player("Maxim", "goalie"));
		
		Team team = new Team("Hawks", "Ulyanovsk", players);
		teamDao.save(team);
	}
}
