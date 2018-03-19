package kr.co.nakseo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.co.nakseo.model.Person;
import kr.co.nakseo.service.PersonService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PsersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getPersonList() {
		try {
			List<Person> persons = personService.findPersonList();
			if(persons.isEmpty()) {
				return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("{}", e);
			return new ResponseEntity<List<Person>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable("id") String id) {
		try {
			Person person = personService.findById(id);
			if(person == null) {
				return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Person>(person, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("{}", e);
			return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}