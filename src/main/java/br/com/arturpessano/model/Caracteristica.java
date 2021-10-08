package br.com.arturpessano.model;

public class Caracteristica {

	public String nome;
	public String mapas;
	public String armas;
	
	
	public Caracteristica(String nome, String mapas, String armas) {
		super();
		this.nome = nome;
		this.mapas = mapas;
		this.armas = armas;
		
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMapas() {
		return mapas;
	}


	public void setMapas(String mapas) {
		this.mapas = mapas;
	}


	public String getArmas() {
		return armas;
	}


	public void setArmas(String armas) {
		this.armas = armas;
	}
	
	
	
	
	
}
