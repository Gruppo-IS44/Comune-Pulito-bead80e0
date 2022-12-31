package com.project.comunepulito;

public class SegnalazioneIdBody {
	
	private Integer utente;
	
	public SegnalazioneIdBody(Integer utente) {
		super();
		this.utente = utente;
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
