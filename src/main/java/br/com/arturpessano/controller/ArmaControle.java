package br.com.arturpessano.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arturpessano.model.Arma;
import br.com.arturpessano.model.Person;
import br.com.arturpessano.service.ArmaServico;

;

@RestController
@RequestMapping("/armas")
public class ArmaControle {
	private List<Arma> listOfArmas = new ArrayList<Arma>();

	@Autowired
	private ArmaServico armaServico;

	@GetMapping
	public List<Arma> findAll() {
		return armaServico.findAll();
	}

	@GetMapping("/{name}")
	public Arma findOne(@PathVariable String name) {
		return armaServico.findOne(name);

	}

	@PostMapping
	public Map<String, String> insart(@RequestBody Arma arma) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSucces = listOfArmas.add(arma);
		if (isSucces) {
			result.put("result", "Pessoa cadastradacomsucesso!!!");
		} else {
			result.put("result", "Não foi possivel cadastrar a pessoa");

		}
		return result;
	}
	@PutMapping
	public Map<String, String> edit(@RequestBody Arma arma) {
		return armaServico.edit(arma);
	
	}
	@DeleteMapping("/{name}")
	public Map<String, String> remove(@PathVariable String name) {
		return armaServico.remove(name);
	}

}