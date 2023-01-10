package com.project.comunepulito;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserLogin {//Classe delle risposte ad un login
	private boolean valido;
	private String token;
	private String nome;
	private String cognome;
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public UserLogin(boolean valido, String token, String nome, String cognome) {
		super();
		this.valido = valido;
		this.token = token;
		this.nome = nome;
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "UserLogin [valido=" + valido + ", token=" + token + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
}

