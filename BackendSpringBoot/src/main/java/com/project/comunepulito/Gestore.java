package com.project.comunepulito;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="gestore")
public class Gestore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id_gestore;
	private String nome;
	private String cognome;
	private String pwd;
	private String email;
	private String sede;
	
	@OneToMany(mappedBy="gestore")
	private Set<Cluster> cluster;
	
	public Integer getId_gestore() {
		return Id_gestore;
	}
	public void setId_gestore(Integer id_gestore) {
		Id_gestore = id_gestore;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}

}
