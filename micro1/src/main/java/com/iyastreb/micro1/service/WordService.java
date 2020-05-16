package com.iyastreb.micro1.service;

import rx.Observable;

public interface WordService {
	Observable<String> getSubject();
	Observable<String> getVerb();
	Observable<String> getArticle();
	Observable<String> getAdjective();
	Observable<String> getNoun();
}
