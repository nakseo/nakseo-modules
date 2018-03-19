package kr.co.nakseo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.co.nakseo.model.Person;
import kr.co.nakseo.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/person")
	public String getPersonList(ModelMap modelMap) {
		List<Person> persons = personService.findPersonList();
		modelMap.addAttribute("persons", persons);
		return "person/list";
	}
	
	@GetMapping("/person/{id}")
	public String getPerson(@PathVariable("id") String id, ModelMap modelMap) {
		Person person = personService.findById(id);
		modelMap.addAttribute("person", person);
		return "person/detail";
	}
	
}
