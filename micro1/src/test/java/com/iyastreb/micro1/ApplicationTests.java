package com.iyastreb.micro1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = "words = foo,bar,baz")
@ActiveProfiles("local-test")
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
