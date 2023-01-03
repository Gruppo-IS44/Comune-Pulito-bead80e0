package com.project.comunepulito;

import java.sql.Blob;


public class SegnalazioneBody {
	private String foto;
	private String descrizione;
	private Integer tipo_rifiuto;
	private Float latitudine;
	private Float longitudine;
	private Integer utente;
	private Integer cluster;
		
	
	public SegnalazioneBody(String foto, Integer utente, Integer tipo_rifiuto, String descrizione, Float latitudine, Float longitudine) {
		super();
		this.foto = foto;
		this.utente = utente;
		this.tipo_rifiuto = tipo_rifiuto;
		this.descrizione = descrizione;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	public Integer getId_utente() {
		return utente;
	}
	public void setId_utente(Integer utente) {
		this.utente = utente;
	}
	public Integer getTipo_rifiuto() {
		return tipo_rifiuto;
	}
	public void setTipo_rifiuto(Integer tipo_rifiuto) {
		this.tipo_rifiuto = tipo_rifiuto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public float getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(Float latitudine) {
		this.latitudine = latitudine;
	}
	public float getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(Float longitudine) {
		this.longitudine = longitudine;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Integer getId_cluster() {
		return cluster;
	}
	public void setId_cluster(Integer cluster) {
		this.cluster = cluster;
	}
	@Override
	public String toString() {
		return "SegnalazioneBody [foto=" + foto + ", Id_utente=" + utente + ", tipo_rifiuto=" + tipo_rifiuto
				+ ", descrizione=" + descrizione + ", latitudine=" + latitudine + ", longitudine=" + longitudine + "]";
	}

	
}
