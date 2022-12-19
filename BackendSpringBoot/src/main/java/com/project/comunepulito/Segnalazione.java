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
	@ManyToOne
	@JoinColumn(name="Id_utente", nullable=false)
	private static Utente Id_utente;
	private Integer Id_segnalazione;
	private LocalDateTime dataora;
	private Point posizione;
	private Blob foto;
	private String descrizione;
	private TIPO_RIFIUTO tipo_rifiuto;
	private STATO_SEGNALAZIONE stato_segnalazione;
	
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
	public static Utente getUtente() {
		return Id_utente;
	}
	public void setUtente(Utente utente) {
		Segnalazione.Id_utente = utente;
	}
	public TIPO_RIFIUTO getTipo_rifiuto() {
		return tipo_rifiuto;
	}
	public void setTipo_rifiuto(TIPO_RIFIUTO tipo_rifiuto) {
				
	}
	public STATO_SEGNALAZIONE getStato_segnalazione() {
		return stato_segnalazione;
	}
	public void setStato_segnalazione(STATO_SEGNALAZIONE stato_segnalazione) {
		this.stato_segnalazione = stato_segnalazione;
	}

}
