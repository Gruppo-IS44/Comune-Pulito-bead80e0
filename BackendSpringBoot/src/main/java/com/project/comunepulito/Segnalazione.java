package com.project.comunepulito;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private String foto;
	private String descrizione;
	private Integer tipo_rifiuto;
	private Integer Id_Stato;

	
	/*@ManyToOne
	@JoinColumn(name="Id_utente", nullable=false)
	private Utente utente;*/
	
	@JoinColumn(name = "Id_utente", insertable = false, updatable = false)
	@ManyToOne(targetEntity = Utente.class, fetch = FetchType.EAGER)
	private Utente utente;
	@Column(name = "Id_utente")
	private Integer Id_utente;
	
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getTipo_rifiuto() {
		return tipo_rifiuto;
	}
	public void setTipo_rifiuto(Integer tipo_rifiuto) {
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
	/*public Integer getId_utente() {
		return utente.getId();
	}
	public void setId_utente(Integer x) {
		this.utente.setId(x);
	}*/
	public Integer getId_utente() {
		return Id_utente;
	}
	public void setId_utente(Integer id_utente) {
		Id_utente = id_utente;
	}

}
