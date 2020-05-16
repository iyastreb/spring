package com.iyastreb.micro1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import rx.Observable;

public class SentenceServiceImplTest {
    @InjectMocks
    private SentenceServiceImpl sentenceService;

    @Mock
    WordService service;
    

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(service.getSubject()).thenReturn(Observable.just("S"));
		Mockito.when(service.getVerb()).thenReturn(Observable.just("V"));
		Mockito.when(service.getArticle()).thenReturn(Observable.just("A"));
		Mockito.when(service.getAdjective()).thenReturn(Observable.just("Ad"));
		Mockito.when(service.getNoun()).thenReturn(Observable.just("N"));
	}
	
	@Test
	void testService() {
		assertEquals("S V A Ad N.", sentenceService.buildSentence());
	}
}
