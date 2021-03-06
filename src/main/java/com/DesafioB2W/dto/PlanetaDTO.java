package com.DesafioB2W.dto;

import java.io.Serializable;
import java.util.Optional;

import com.DesafioB2W.domain.Planeta;

public class PlanetaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	
	public PlanetaDTO() {	
	}
	
	public PlanetaDTO(Planeta obj) {
		id = obj.getId();
		nome = obj.getNome();
		clima = obj.getClima();
		terreno = obj.getTerreno();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
}
