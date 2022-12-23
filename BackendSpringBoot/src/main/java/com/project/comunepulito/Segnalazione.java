package com.project.comunepulito;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private Float latitudine;
	private Float longitudine;
	private Blob foto;
	private String descrizione;
	private String tipo_rifiuto;
	private Integer Id_Stato; 
	
	@ManyToOne
	private Utente Id_utente;
	
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
	public String getTipo_rifiuto() {
		return tipo_rifiuto;
	}
	public void setTipo_rifiuto(String tipo_rifiuto) {
		this.tipo_rifiuto=tipo_rifiuto;
	}
	public Integer getId_Stato() {
		return Id_Stato;
	}
	public void setId_Stato(Integer id_Stato) {
		Id_Stato = id_Stato;
	}
	public Float getLatitudine() {
		return latitudine;
	}
	public void setLatitudine(Float latitudine) {
		this.latitudine = latitudine;
	}
	public Float getLongitudine() {
		return longitudine;
	}
	public void setLongitudine(Float longitudine) {
		this.longitudine = longitudine;
	}
	public Utente getId_utente() {
		return Id_utente;
	}
	public void setId_utente(Utente id_utente) {
		Id_utente = id_utente;
	}

}
