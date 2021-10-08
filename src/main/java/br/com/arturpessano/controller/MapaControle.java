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

import br.com.arturpessano.model.Mapa;
import br.com.arturpessano.model.Person;
import br.com.arturpessano.service.MapaServico;
import br.com.arturpessano.service.PersonService;

@RestController
@RequestMapping("/mapa")
public class MapaControle {
	
	private List<Mapa> listOfMapas = new ArrayList<Mapa>();
	@Autowired
		private MapaServico mapaServico;
	
	@GetMapping
	public List<Mapa> findAll() {
		return mapaServico.findAll();
		

	}
	

	@GetMapping("/{name}")
	public Mapa findOne(@PathVariable String name) {
		return null;
	
	}

	@PostMapping
	public Map<String, String> insart(@RequestBody Mapa mapa) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSucces = listOfMapas.add(mapa);
		if (isSucces) {
			result.put("result", "Pessoa cadastradacomsucesso!!!");
		} else {
			result.put("result", "Não foi possivel cadastrar a pessoa");

		}
		return result;
	}
	@PutMapping
	public Map<String, String> edit(@RequestBody Mapa mapa) {
		Map<String, String> result = new HashMap<String, String>();
		for (Mapa element : listOfMapas) {
			if (element.getDuracaodapartida().equalsIgnoreCase(mapa.getDuracaodapartida())) {
				int index = listOfMapas.indexOf(element);
				listOfMapas.set(index, mapa);
				result.put("result", "Pessoa editada com sucesso!!!");
				return result;
			}

		}
		result.put("result", "Não foi possivel editar a pessoa!!");
		return result;

	}
	@DeleteMapping("{mapa}")
	public Map<String, String> remove(@PathVariable String nome) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSuccess = listOfMapas.removeIf((mapa) -> mapa.getDuracaodapartida().equalsIgnoreCase(nome));
		if (isSuccess) {
			result.put("result", "Pessoa removida com sucesso!!!");
		} else {
			result.put("result", "Não foi possivel remover a pessoa!!!");
		}
		return result;
	}

}
	
