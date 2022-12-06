package com.project.comunepulito;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="market")
public class Market {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@OneToMany(mappedBy="market")
	private Set<Reward> reward;
	private Point posizione;
	private float raggio;

	public ArrayList<String> mercato = new ArrayList<String>();
	
	
	
	
	
	

}
