package br.com.arturpessano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arturpessano.model.Person;
import br.com.arturpessano.service.PersonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {
	private List<Person> listOfPersons = new ArrayList<Person>();
@Autowired
	private PersonService personService;

	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();

	}

	@GetMapping("/{name}")
	public Person findOne(@PathVariable String name) {
		return null;
	
	}

	@PostMapping
	public Map<String, String> insart(@RequestBody Person person) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSucces = listOfPersons.add(person);
		if (isSucces) {
			result.put("result", "Pessoa cadastradacomsucesso!!!");
		} else {
			result.put("result", "Não foi possivel cadastrar a pessoa");

		}
		return result;
	}

	@PutMapping
	public Map<String, String> edit(@RequestBody Person person) {
		Map<String, String> result = new HashMap<String, String>();
		for (Person element : listOfPersons) {
			if (element.getName().equalsIgnoreCase(person.getName())) {
				int index = listOfPersons.indexOf(element);
				listOfPersons.set(index, person);
				result.put("result", "Pessoa editada com sucesso!!!");
				return result;
			}

		}
		result.put("result", "Não foi possivel editar a pessoa!!");
		return result;

	}

	@DeleteMapping("{name}")
	public Map<String, String> remove(@PathVariable String name) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSuccess = listOfPersons.removeIf((person) -> person.getName().equalsIgnoreCase(name));
		if (isSuccess) {
			result.put("result", "Pessoa removida com sucesso!!!");
		} else {
			result.put("result", "Não foi possivel remover a pessoa!!!");
		}
		return result;
	}

}
