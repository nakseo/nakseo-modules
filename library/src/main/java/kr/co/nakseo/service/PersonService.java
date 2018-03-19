package kr.co.nakseo.service;

import java.util.List;

import kr.co.nakseo.model.Person;

public interface PersonService {

	List<Person> findPersonList();

	Person findById(String id);

}
