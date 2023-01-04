package com.project.comunepulito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="utente")
public class Utente implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id_utente;
	private String nome;
	private String cognome;
	private String email;
	private String pwd;
	private Integer warn;
	private Integer bilancio;
	private Boolean ban;
	
	@OneToMany(mappedBy="utente")
	private Set<Segnalazione> segnalazioni;
	
	public Integer getId() {
		return Id_utente;
	}
	public void setId(Integer Id_utente) {
		this.Id_utente = Id_utente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getWarn() {
		return warn;
	}
	public void setWarn(Integer warn) {
		this.warn = warn;
	}
	public Integer getBilancio() {
		return bilancio;
	}
	public void setBilancio(Integer bilancio) {
		this.bilancio = bilancio;
	}
	public Boolean getBan() {
		return ban;
	}
	public void setBan(Boolean ban) {
		this.ban = ban;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new ArrayList<>();
	     authorities.add(new SimpleGrantedAuthority("UTENTE"));
	     return authorities;
	}
	@Override
	public String getPassword() {
		return this.getPwd();
	}
	@Override
	public String getUsername() {
		return this.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
