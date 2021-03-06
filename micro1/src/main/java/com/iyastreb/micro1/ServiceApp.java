package com.iyastreb.micro1;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.iyastreb.micro1.dao.TeamDao;
import com.iyastreb.micro1.domain.Player;
import com.iyastreb.micro1.domain.Team;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class ServiceApp extends SpringBootServletInitializer {
	@Autowired
	private TeamDao teamDao;

	public static void main(String[] args) {
		SpringApplication.run(ServiceApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ServiceApp.class);
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
