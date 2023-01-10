package com.project.comunepulito;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RisolviClusterBody {
	
	private Integer Id_Stato;
	private Integer segnalazione;
	private Integer Id_Utente;
	
	@JsonCreator
	public RisolviClusterBody(@JsonProperty("segnalazione")String segnalazione, @JsonProperty("Id_Stato")String Id_Stato,@JsonProperty("Id_Utente")String Id_Utente) {
		super();
		this.segnalazione = Integer.parseInt(segnalazione);
		this.Id_Stato = Integer.parseInt(Id_Stato);
		this.Id_Utente = Integer.parseInt(Id_Utente);
	}

	
	public Integer getId_Stato() {
		return Id_Stato;
	}
	public void setId_Stato(Integer id_Stato) {
		Id_Stato = id_Stato;
	}
	public Integer getSegnalazione() {
		return segnalazione;
	}
	public void setSegnalazione(Integer segnalazione) {
		this.segnalazione = segnalazione;
	}
	public Integer getId_Utente() {
		return Id_Utente;
	}
	public void setId_Utente(Integer id_Utente) {
		Id_Utente = id_Utente;
	}
	@Override
	public String toString() {
		return "RisolviClusterBody [Id_Stato=" + Id_Stato + ", segnalazione=" + segnalazione + "]";
	}

}
