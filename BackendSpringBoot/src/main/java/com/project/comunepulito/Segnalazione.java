package com.project.comunepulito;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.*;
import java.awt.Point;
import java.sql.Blob;

@Entity
@Table(name="segnalazione")
public class Segnalazione {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id_segnalazione;
	private LocalDateTime dataora;
	private Point posizione;
	private Blob foto;
	private String descrizione;
	
	public Integer getId_segnalazione() {
		return Id_segnalazione;
	}
	public void setId_segnalazione(Integer id_segnalazione) {
		Id_segnalazione = id_segnalazione;
	}
	public LocalDateTime getDataora() {
		return dataora;
	}
	public void setDataora(LocalDateTime dataora) {
		this.dataora = dataora;
	}
	public Point getPosizione() {
		return posizione;
	}
	public void setPosizione(Point posizione) {
		this.posizione = posizione;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	

}
