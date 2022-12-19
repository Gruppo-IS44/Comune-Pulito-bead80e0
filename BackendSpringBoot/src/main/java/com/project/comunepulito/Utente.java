package com.project.comunepulito;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="utente")
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OneToMany(mappedBy="utente")
	private Set<Segnalazione> segnalazioni;
	private Integer Id_utente;
	private String nome;
	private String cognome;
	private String email;
	private String pwd;
	private Integer warn;
	private Integer bilancio;
	private Boolean ban;
	
	public Integer getId() {
		return Id_utente;
	}
	public void setId(Integer Id_utente) {
		this.Id_utente = Id_utente;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getWarn() {
		return warn;
	}
	public void setWarn(Integer warn) {
		this.warn = warn;
	}
	public Integer getBilancio() {
		return bilancio;
	}
	public void setBilancio(Integer bilancio) {
		this.bilancio = bilancio;
	}
	public Boolean getBan() {
		return ban;
	}
	public void setBan(Boolean ban) {
		this.ban = ban;
	}
}
