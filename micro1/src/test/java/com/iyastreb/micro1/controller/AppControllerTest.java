package com.iyastreb.micro1.controller;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iyastreb.micro1.service.SentenceService;

@SpringBootTest(properties = "words = foo,bar,baz")
@AutoConfigureMockMvc
@ActiveProfiles("local-test")
public class AppControllerTest {
	@Autowired
	MockMvc mockMvc;
	
    @InjectMocks
    private AppController controller;

    @Mock
    private SentenceService sentenceService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testWord() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(jsonPath("$", anyOf(is("foo"), is("bar"), is("baz"))));
	}

	@Test
	public void testSentence() throws Exception {
		MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
		Mockito.when(sentenceService.buildSentence()).thenReturn("sentence");
		
		mvc.perform(get("/sentence"))
			.andExpect(jsonPath("$", containsString("sentence<br>sentence<br>sentence<br>")));
	}
}
