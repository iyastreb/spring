package com.iyastreb.micro1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyastreb.micro1.dao.AdjClient;
import com.iyastreb.micro1.dao.ArticleClient;
import com.iyastreb.micro1.dao.NounClient;
import com.iyastreb.micro1.dao.SubjectClient;
import com.iyastreb.micro1.dao.VerbClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
		return Observable.fromCallable(() -> subjectClient.getWord())
				.subscribeOn(Schedulers.computation());
	}

	@Override
	@HystrixCommand(fallbackMethod = "getEmptyString")
	public Observable<String> getVerb() {
		return Observable.fromCallable(() -> verbClient.getWord())
				.subscribeOn(Schedulers.computation());
	}

	@Override
	@HystrixCommand(fallbackMethod = "getEmptyString")
	public Observable<String> getArticle() {
		return Observable.fromCallable(() -> articleClient.getWord())
				.subscribeOn(Schedulers.computation());
	}

	@Override
	@HystrixCommand(fallbackMethod = "getEmptyString")
	public Observable<String> getAdjective() {
		return Observable.fromCallable(() -> adjClient.getWord())
				.subscribeOn(Schedulers.computation());
	}

	@Override
	@HystrixCommand(fallbackMethod = "getDefaultNoun")
	public Observable<String> getNoun() {
		return Observable.fromCallable(() -> nounClient.getWord())
				.subscribeOn(Schedulers.computation());
	}
	
	public Observable<String> getEmptyString() {
		return Observable.just("");
	}
	
	public Observable<String> getDefaultSubject() {
		return Observable.just("Someone");
	}
	
	public Observable<String> getDefaultNoun() {
		return Observable.just("something");
	}
}
