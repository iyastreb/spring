package com.iyastreb.micro1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.iyastreb.micro1.dao.AdjClient;
import com.iyastreb.micro1.dao.ArticleClient;
import com.iyastreb.micro1.dao.NounClient;
import com.iyastreb.micro1.dao.SubjectClient;
import com.iyastreb.micro1.dao.VerbClient;

public class SentenceServiceImplTest {
	
	SentenceServiceImpl service;

	@BeforeEach
	public void setup() {
		service = new SentenceServiceImpl();
		
		NounClient nounClient = Mockito.mock(NounClient.class);
		AdjClient adjClient = Mockito.mock(AdjClient.class);
		ArticleClient articleClient = Mockito.mock(ArticleClient.class);
		VerbClient verbClient = Mockito.mock(VerbClient.class);
		SubjectClient subjectClient = Mockito.mock(SubjectClient.class);

		service.setAdjClient(adjClient);
		service.setArticleClient(articleClient);
		service.setNounClient(nounClient);
		service.setVerbClient(verbClient);
		service.setSubjectClient(subjectClient);
		
		Mockito.when(subjectClient.getWord()).thenReturn("S");
		Mockito.when(verbClient.getWord()).thenReturn("V");
		Mockito.when(articleClient.getWord()).thenReturn("A");
		Mockito.when(adjClient.getWord()).thenReturn("Ad");
		Mockito.when(nounClient.getWord()).thenReturn("N");
	}
	
	@Test
	void testService() {
		assertEquals("S V A Ad N.", service.buildSentence());
	}
}
