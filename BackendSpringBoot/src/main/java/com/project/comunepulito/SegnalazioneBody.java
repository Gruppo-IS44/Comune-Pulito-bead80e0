package com.project.comunepulito;

import java.awt.Point;
import java.sql.Blob;

public class SegnalazioneBody {
	private String descrizione;	
	private Blob foto;
	private Point posizione;
	private TIPO_RIFIUTO tipo_rifiuto;
	private STATO_SEGNALAZIONE stato_segnalazione;
	
	public SegnalazioneBody(String descrizione, Blob foto, STATO_SEGNALAZIONE tipo_segnalazione, Point posizione,
			TIPO_RIFIUTO tipo_rifiuto) {
		super();
		this.descrizione = descrizione;
		this.foto = foto;
		this.stato_segnalazione = tipo_segnalazione;
		this.posizione = posizione;
		this.tipo_rifiuto = tipo_rifiuto;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public STATO_SEGNALAZIONE getTipo_segnalazione() {
		return stato_segnalazione;
	}
	public void setTipo_segnalazione(STATO_SEGNALAZIONE tipo_segnalazione) {
		this.stato_segnalazione = tipo_segnalazione;
	}
	public Point getPosizione() {
		return posizione;
	}
	public void setPosizione(Point posizione) {
		this.posizione = posizione;
	}
	public TIPO_RIFIUTO getTipo_rifiuto() {
		return tipo_rifiuto;
	}
	public void setTipo_rifiuto(TIPO_RIFIUTO tipo_rifiuto) {
		this.tipo_rifiuto = tipo_rifiuto;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}

@Override
public String toString() {
	return "SegnalazioneBody [descrizione=" + descrizione + ", foto=" + foto + ", tipo_segnalazione="
			+ stato_segnalazione + ", posizione=" + posizione + ", tipo_rifiuto=" + tipo_rifiuto + "]";
}	
}