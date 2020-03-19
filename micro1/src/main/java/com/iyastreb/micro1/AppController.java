package com.iyastreb.micro1;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/old/{name}")
	public @ResponseBody Team team(@PathVariable String name) {
		return teamDao.findByName(name);
	}
}
