package br.com.arturpessano.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.arturpessano.model.Person;

@Service
public class PersonService {
	private List<Person> listOfPersons = new ArrayList<Person>();

	PersonService() {
		listOfPersons.add(new Person("Anderson", "choren", "06/09/1991", "andersochoren@gmail.com"));
		listOfPersons.add(new Person("João", "Silva", "22/06/1980", "joao.silva@gmail.com"));

	}

	public List<Person> findAll() {
		return this.listOfPersons;

	}

	public Person findOne(String name) {
		for (Person person : listOfPersons) {
			if (person.getName().equalsIgnoreCase(name)) {

			}
		}
		return null;
	}
}