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

import br.com.arturpessano.model.Caracteristica;
import br.com.arturpessano.model.Person;
import br.com.arturpessano.service.CaracteristicaServico;



@RestController
@RequestMapping("/caracteristica")
public class CaracteristicaControle {
	private List<Caracteristica> listOfCaracteristicas = new ArrayList<Caracteristica>();


	@Autowired
	private CaracteristicaServico carecteristicaServico;
	
	
	@GetMapping
	public List<Caracteristica> findAll() {
		return carecteristicaServico.findAll();

	}
	
	@GetMapping("/{name}")
	public Caracteristica findOne(@PathVariable String name) {
		return null;
	}
	
	@PostMapping
	public Map<String, String> insart(@RequestBody Caracteristica caracteristica) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSucces = listOfCaracteristicas.add(caracteristica);
		if (isSucces) {
			result.put("result", "Pessoa cadastradacomsucesso!!!");
		} else {
			result.put("result", "Não foi possivel cadastrar a pessoa");

		}
		return result;
	}
	
	@PutMapping
	public Map<String, String> edit(@RequestBody Caracteristica caracteristica) {
		Map<String, String> result = new HashMap<String, String>();
		for (Caracteristica element : listOfCaracteristicas) {
			if (element.getNome().equalsIgnoreCase(caracteristica.getNome())) {
				int index = listOfCaracteristicas.indexOf(element);
				listOfCaracteristicas.set(index, caracteristica);
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
		boolean isSuccess = listOfCaracteristicas.removeIf((caracteristica) -> caracteristica.getNome().equalsIgnoreCase(name));
		if (isSuccess) {
			result.put("result", "Pessoa removida com sucesso!!!");
		} else {
			result.put("result", "Não foi possivel remover a pessoa!!!");
		}
		return result;
	
}
}

