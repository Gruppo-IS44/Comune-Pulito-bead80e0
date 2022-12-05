package com.project.comunepulito;

import java.awt.Point;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cluster")
public class Cluster{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OneToMany(mappedBy="cluster")
	private Set<Segnalazione> segnalazioni;
	private Integer Id_cluster;
	private Point posizione;
	private float raggio;
	//private Integer Id_stato; (non sappiamo come va definito)
	@ManyToOne
	@JoinColumn(name="Id_Gestore", nullable=false)
	private Gestore gestore;
	
	public Set<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}
	public void setSegnalazioni(Set<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}
	public Integer getId_cluster() {
		return Id_cluster;
	}
	public void setId_cluster(Integer id_cluster) {
		Id_cluster = id_cluster;
	}
	public Point getPosizione() {
		return posizione;
	}
	public void setPosizione(Point posizione) {
		this.posizione = posizione;
	}
	public float getRaggio() {
		return raggio;
	}
	public void setRaggio(float raggio) {
		this.raggio = raggio;
	}
	public Gestore getGestore() {
		return gestore;
	}
	public void setGestore(Gestore gestore) {
		this.gestore = gestore;
	}
	
	
	
 
 

}
