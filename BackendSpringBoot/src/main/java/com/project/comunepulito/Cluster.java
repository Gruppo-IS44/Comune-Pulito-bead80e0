package com.project.comunepulito;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cluster")
public class Cluster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id_cluster;
	
	private Float Latitudine;
	private Float Longitudine;
	private Float raggio;
	private Integer Id_stato;
	
	@OneToMany(mappedBy="cluster")
	private Set<Segnalazione> segnalazioni;
	
	@JoinColumn(name = "Id_gestore", insertable = false, updatable = false)
	@ManyToOne(targetEntity = Gestore.class, fetch = FetchType.EAGER)
	private Gestore gestore;
	@Column(name = "Id_gestore")
	private Integer Id_gestore;


	/*public void setSegnalazioni(Set<Segnalazione> segnalazioni) {			//NECESSARIO?
		this.segnalazioni = segnalazioni;
	}*/
	public Integer getId_cluster() {
		return Id_cluster;
	}
	public void setId_cluster(Integer id_cluster) {
		Id_cluster = id_cluster;
	}
	public Float getRaggio() {
		return raggio;
	}
	public void setRaggio(Float raggio) {
		this.raggio = raggio;
	}
	public Integer getId_stato() {
		return Id_stato;
	}
	public void setId_stato(Integer id_stato) {
		Id_stato = id_stato;
	}
	public Float getLatitudine() {
		return Latitudine;
	}
	public void setLatitudine(Float latitudine) {
		Latitudine = latitudine;
	}
	public Float getLongitudine() {
		return Longitudine;
	}
	public void setLongitudine(Float longitudine) {
		Longitudine = longitudine;
	}
	public Integer getId_gestore() {
		return Id_gestore;
	}
	public void setId_gestore(Integer id_gestore) {
		Id_gestore = id_gestore;
	}
}

