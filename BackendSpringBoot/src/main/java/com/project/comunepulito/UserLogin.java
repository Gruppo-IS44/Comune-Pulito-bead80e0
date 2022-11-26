package com.project.comunepulito;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserLogin {//Classe delle risposte ad un login
	private boolean valido;
	private String token;
	
	public UserLogin(boolean valido, String token) {
		this.valido = valido;
		this.token = token;
	}
	


	public boolean getValido() {
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



	@Override
	public String toString() {
		return "UserLogin [valido=" + valido + ", token=" + token + "]";
	}
	
}

