package com.project.comunepulito;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SegnalazioneIdBody {
	private Integer utente;
	
	
	@JsonCreator
	public SegnalazioneIdBody(@JsonProperty("utente")String utente) {
		super();
		this.utente = Integer.parseInt(utente);
	}

	public Integer getId_utente() {
		return utente;
	}

	public void setId_utente(Integer utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "SegnalazioneIdBody [utente=" + utente + "]";
	}	
}
