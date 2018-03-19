package test.nakseo.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.nakseo.WebApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = WebApplication.class)
public class PersonControllerTest {

	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void getPersons() {
		ResponseEntity<String> response = this.testRestTemplate.getForEntity("/person", String.class);
		log.debug("\n {}", response);
	}
	
}
