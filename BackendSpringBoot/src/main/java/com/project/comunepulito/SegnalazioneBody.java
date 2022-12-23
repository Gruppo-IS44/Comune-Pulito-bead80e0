package com.project.comunepulito;

import java.awt.Point;
import java.sql.Blob;

public class SegnalazioneBody {
	private Blob foto;
	private Integer Id_utente;
	private String tipo_rifiuto;
	private String descrizione;
	private int[] posizione;
		
	public SegnalazioneBody(Blob foto, Integer id_utente, String tipo_rifiuto, String descrizione, Point posizione) {
		super();
		this.foto = foto;
		this.Id_utente = id_utente;
		this.tipo_rifiuto = tipo_rifiuto;
		this.descrizione = descrizione;
		this.posizione[0] = ;
	}
	public Integer getId_utente() {
		return Id_utente;
	}
	public void setId_utente(Integer id_utente) {
		Id_utente = id_utente;
	}
	public String getTipo_rifiuto() {
		return tipo_rifiuto;
	}
	public void setTipo_rifiuto(String tipo_rifiuto) {
		this.tipo_rifiuto = tipo_rifiuto;
	}
	public Point getPosizione() {
		return posizione;
	}
	public void setPosizione(Point posizione) {
		this.posizione = posizione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	
	@Override
	public String toString() {
		return "SegnalazioneBody [foto=" + foto + ", Id_utente=" + Id_utente + ", tipo_rifiuto=" + tipo_rifiuto
				+ ", descrizione=" + descrizione + ", posizione=" + posizione + "]";
	}

	
}
