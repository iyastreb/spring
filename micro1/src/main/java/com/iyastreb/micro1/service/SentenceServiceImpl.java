package com.iyastreb.micro1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {
	@Autowired
	private WordService service;

	@Override
	public String buildSentence() {
		String res = String.format("%s %s %s %s %s.",
				service.getSubject(),
				service.getVerb(),
				service.getArticle(),
				service.getAdjective(),
				service.getNoun());
		return res;
	}
}
