package br.com.arturpessano.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.arturpessano.model.Mapa;


@Service

public class MapaServico {
	
	
	public class MapaService {
		private List<Mapa> listOfMapas = new ArrayList<Mapa>();

		MapaService() {
			listOfMapas.add(new Mapa("Erangel","Miramar"));
			

		}

		public List<Mapa> findAll() {
			return this.listOfMapas;

		}

		public Mapa findOne(String name) {
			for (Mapa mapa : listOfMapas) {
				if (mapa.getDuracaodapartida().equalsIgnoreCase(name)) {

				}
			}
			return null;
		}
	}

	public List<Mapa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	}


