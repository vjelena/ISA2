package com.ftn.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ponuda implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String cena;
	
	@Column(nullable = false)
	private int status;			//0 odbijen 1 prihvacen
	
	@ManyToOne(optional = false)
	@JsonIgnore
	private Oglas oglas;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Korisnik ponudjac;
	
	public Ponuda(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public Korisnik getPonudjac() {
		return ponudjac;
	}

	public void setPonudjac(Korisnik ponudjac) {
		this.ponudjac = ponudjac;
	}

	public Oglas getOglas() {
		return oglas;
	}

	public void setOglas(Oglas oglas) {
		this.oglas = oglas;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
