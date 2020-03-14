package com.iyastreb.micro1;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StringController {

	@RequestMapping("/greeting/{name}")
	public String greeting(Map<Object, Object> model,
			@PathVariable String name) {
		model.put("name", name.toUpperCase());
		return "greeting";
	}
}
