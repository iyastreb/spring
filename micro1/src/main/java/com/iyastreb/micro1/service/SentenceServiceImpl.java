package com.iyastreb.micro1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.rxjava3.core.Observable;

@Service
public class SentenceServiceImpl implements SentenceService {
	@Autowired
	private WordService service;

	@Override
	public String buildSentence() {
		return Observable.zip(service.getSubject(),
							  service.getVerb(),
							  service.getArticle(),
							  service.getAdjective(), 
							  service.getNoun(),
				 (subject, verb, article, adj, noun) -> 
					String.format("%s %s %s %s %s.", subject, verb, article, adj, noun))
				.blockingFirst();
	}
}
