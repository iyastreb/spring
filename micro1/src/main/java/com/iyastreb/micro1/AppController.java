package com.iyastreb.micro1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyastreb.micro1.dao.TeamDao;
import com.iyastreb.micro1.domain.Team;

@Controller
public class AppController {
	@Autowired
	private TeamDao teamDao;

	@Value("${name}") String name;

	@RequestMapping("/old/{name}")
	public @ResponseBody Team team(@PathVariable String name) {
		return teamDao.findByName(name);
	}
	
	@RequestMapping("/name")
	public @ResponseBody String name() {
		return "My name is " + name;
	}
}
