package com.project.comunepulito;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.*;
import java.util.Set;

@Entity
@Table(name="ordine")
public class Ordine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OneToMany(mappedBy="segnalazioni")
	private Set<Segnalazione> segnalazioni;
	private Integer Id_ordine;
	private LocalDateTime dataora;
	private Short quantità;
	@ManyToOne
	@JoinColumn(name="Id_Utente", nullable=false)
	private Utente utente;
	
	public Set<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}
	public void setSegnalazioni(Set<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}
	public Integer getId_ordine() {
		return Id_ordine;
	}
	public void setId_ordine(Integer id_ordine) {
		Id_ordine = id_ordine;
	}
	public LocalDateTime getDataora() {
		return dataora;
	}
	public void setDataora(LocalDateTime dataora) {
		this.dataora = dataora;
	}
	public Short getQuantità() {
		return quantità;
	}
	public void setQuantità(Short quantità) {
		this.quantità = quantità;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
}
