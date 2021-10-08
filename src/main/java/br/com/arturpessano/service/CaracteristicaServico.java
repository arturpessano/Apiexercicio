package br.com.arturpessano.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.arturpessano.model.Caracteristica;
import br.com.arturpessano.model.Person;

@Service
public class CaracteristicaServico {

	private List<Caracteristica> listOfCaracteristica = new ArrayList<Caracteristica>();
	
	public CaracteristicaServico() {
		listOfCaracteristica.add(new Caracteristica("Player", "Unknown's", "battlegrounds"));
		
	}
	public List<Caracteristica> findAll() {
		return this.listOfCaracteristica;
	}
	
		public Caracteristica findOne(String name) {
			for (Caracteristica caracteristica : listOfCaracteristica) {
				if (caracteristica.getNome().equalsIgnoreCase(name)) {

				}
			}
			return null;
	
	}
		
		
}
