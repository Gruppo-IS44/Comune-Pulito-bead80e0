package com.project.comunepulito;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RisolviClusterBody {
	private Cluster cluster;
	private List<Segnalazione> segnalazioni;
	
	@JsonCreator
	public RisolviClusterBody(@JsonProperty("cluster")Cluster cluster, @JsonProperty("segnalazioni")List<Segnalazione> segnalazioni) {
		super();
		this.cluster=cluster;
		this.segnalazioni=segnalazioni;
	}
	@Override
	public String toString() {
		return "RisolviClusterBody [cluster=" + cluster + ", segnalazioni=" + segnalazioni + "]";
	}
	public Cluster getCluster() {
		return cluster;
	}
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}
	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}
}
