package com.iyastreb.micro1;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.iyastreb.micro1.dao.TeamDao;
import com.iyastreb.micro1.domain.Team;

@Controller
public class AppController {
	@Autowired
	private TeamDao teamDao;
	
	@Autowired
	private DiscoveryClient client;

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
		return  getWord("client-subject") + " " + 
				getWord("client-verb") + " " + 
				getWord("client-article") + " " +
				getWord("client-adjective") + " " + 
				getWord("client-noun") + ".";
	}

	public String getWord(String service) {
		List<ServiceInstance> list = client.getInstances(service);
		if (list != null && list.size() > 0) {
			URI uri = list.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}

}
