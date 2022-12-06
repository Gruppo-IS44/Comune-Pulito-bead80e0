package com.project.comunepulito;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reward")
public class Reward {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id_reward;
	private String nome;
	private String descrizione;
	private Integer costo;
	private Integer stock;
	
	public Integer getId_reward() {
		return Id_reward;
	}
	public void setId_reward(Integer id_reward) {
		Id_reward = id_reward;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	

}
