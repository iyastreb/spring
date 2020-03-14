package com.iyastreb.micro1;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyastreb.micro1.domain.Player;
import com.iyastreb.micro1.domain.Team;

@Controller
public class AppController {
	private Team team;
	
	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player("Ilia", "forward"));
		players.add(new Player("Maxim", "goalie"));
		
		team = new Team("Hawks", "Ulyanovsk", players);
	}

	@RequestMapping("/team")
	public @ResponseBody Team team() {
		return team;
	}
}
