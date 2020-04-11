package com.iyastreb.micro1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iyastreb.micro1.dao.TeamDao;
import com.iyastreb.micro1.domain.Team;
import com.iyastreb.micro1.service.SentenceService;

@Controller
public class AppController {
	@Autowired
	private TeamDao teamDao;

	@Autowired
	private SentenceService sentenceService;
	
	@Value("${words}") String words;

	@RequestMapping("/old/{name}")
	public @ResponseBody Team team(@PathVariable String name) {
		return teamDao.findByName(name);
	}
	
	@GetMapping("/")
	public @ResponseBody String getWord() {
		String[] wordArray = words.split(",");
		int i = (int) Math.round(Math.random() * (wordArray.length - 1));
		return wordArray[i];
	}
	
	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		return String.format("%s<br>%s<br>%s<br>",
				sentenceService.buildSentence(),
				sentenceService.buildSentence(),
				sentenceService.buildSentence());
	}
}
