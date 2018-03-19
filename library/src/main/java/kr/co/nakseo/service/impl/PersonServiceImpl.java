package kr.co.nakseo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.nakseo.model.Person;
import kr.co.nakseo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public List<Person> findPersonList() {
		return this.selectPersonList();
	}

	@Override
	public Person findById(String id) {
		List<Person> persons = this.selectPersonList();
		for (Person item : persons) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	private List<Person> selectPersonList() {
		List<Person> persons = new ArrayList<>();

		Person person = new Person();
		person.setId("nakseo");
		person.setName("장명광");
		person.setAge("35");
		person.setGender("M");
		persons.add(person);

		person = new Person();
		person.setId("mango");
		person.setName("망고");
		person.setAge("35");
		person.setGender("M");
		persons.add(person);

		person = new Person();
		person.setId("mango-nakseo");
		person.setName("장지운");
		person.setAge("35");
		person.setGender("M");
		persons.add(person);

		return persons;
	}

}
