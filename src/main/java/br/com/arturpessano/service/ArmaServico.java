package br.com.arturpessano.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.arturpessano.model.Arma;

@Service
public class ArmaServico {

	private List<Arma> listOfArmas = new ArrayList<Arma>();

	public ArmaServico() {
		listOfArmas.add(new Arma("Akm", "calibre 762", "dano de golpe 47"));
		listOfArmas.add(new Arma("M416", "calibre 556", "dano de golpe 40"));

	}

	public List<Arma> findAll() {
		return this.listOfArmas;

	}

	public Arma findOne(String name) {
		for (Arma arma : listOfArmas) {
			if (arma.getNomedaarma().equalsIgnoreCase(name)) {
				return arma;
			}
		}
		return null;
	}
	
	public Map<String, String> edit(Arma arma) {
		Map<String, String> result = new HashMap<String, String>();
		for (Arma element : listOfArmas) {
			System.out.print(element.getNomedaarma());
			if (element.getNomedaarma().equalsIgnoreCase(arma.getNomedaarma())) {
				int index = listOfArmas.indexOf(element);
				listOfArmas.set(index, arma);
				result.put("result", "Arma editada com sucesso!!!");
				return result;
			}

		}
		result.put("result", "Não foi possivel editar a arma!!");
		return result;
	
	}

	public Map<String, String> remove(String name) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSuccess = listOfArmas.removeIf((arma) -> arma.getDano().equalsIgnoreCase(name));
		if (isSuccess) {
			result.put("result", "Arma removida com sucesso!!!");
		} else {
			result.put("result", "Não foi possivel remover a arma!!!");
		}
		return result;
	}
}
