package com.iyastreb.micro1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyastreb.micro1.dao.AdjClient;
import com.iyastreb.micro1.dao.ArticleClient;
import com.iyastreb.micro1.dao.NounClient;
import com.iyastreb.micro1.dao.SubjectClient;
import com.iyastreb.micro1.dao.VerbClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import rx.Observable;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
	private NounClient nounClient;
	@Autowired
	private AdjClient adjClient;
	@Autowired
	private ArticleClient articleClient;
	@Autowired
	private VerbClient verbClient;
	@Autowired
	private SubjectClient subjectClient;

	@Override
	@HystrixCommand(fallbackMethod = "getDefaultSubject")
	public Observable<String> getSubject() {
		return subjectClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getEmptyString")
	public Observable<String> getVerb() {
		return verbClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getEmptyString")
	public Observable<String> getArticle() {
		return articleClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getEmptyString")
	public Observable<String> getAdjective() {
		return adjClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getDefaultNoun")
	public Observable<String> getNoun() {
		return nounClient.getWord();
	}
	
	public String getEmptyString() {
		return "";
	}
	
	public String getDefaultSubject() {
		return "Someone";
	}
	
	public String getDefaultNoun() {
		return "something";
	}
}
