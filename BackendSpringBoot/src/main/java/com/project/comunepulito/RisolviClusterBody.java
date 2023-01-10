package com.project.comunepulito;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RisolviClusterBody {
	
	private Integer Id_Stato;
	private Integer segnalazione;
	
	@JsonCreator
	public RisolviClusterBody(@JsonProperty("segnalazione")String segnalazione, @JsonProperty("Id_Stato")String Id_Stato) {
		super();
		this.segnalazione = Integer.parseInt(segnalazione);
		this.Id_Stato = Integer.parseInt(Id_Stato);
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
	
	@Override
	public String toString() {
		return "RisolviClusterBody [Id_Stato=" + Id_Stato + ", segnalazione=" + segnalazione + "]";
	}
}
