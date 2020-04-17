package com.iyastreb.micro1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SentenceServiceImplTest {
    @InjectMocks
    private SentenceServiceImpl sentenceService;

    @Mock
    WordService service;
    

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(service.getSubject()).thenReturn("S");
		Mockito.when(service.getVerb()).thenReturn("V");
		Mockito.when(service.getArticle()).thenReturn("A");
		Mockito.when(service.getAdjective()).thenReturn("Ad");
		Mockito.when(service.getNoun()).thenReturn("N");
	}
	
	@Test
	void testService() {
		assertEquals("S V A Ad N.", sentenceService.buildSentence());
	}
}
