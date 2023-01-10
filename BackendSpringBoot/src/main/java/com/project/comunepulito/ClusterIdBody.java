package com.project.comunepulito;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClusterIdBody {
	private Integer gestore;
	
	
	@JsonCreator
	public ClusterIdBody(@JsonProperty("gestore")String gestore) {
		super();
		this.gestore = Integer.parseInt(gestore);
	}


	public Integer getId_gestore() {
		return gestore;
	}


	public void setId_gestore(Integer gestore) {
		this.gestore = gestore;
	}


	@Override
	public String toString() {
		return "ClusterIdBody [gestore=" + gestore + "]";
	}

}


