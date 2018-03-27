package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Repertoar implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(optional = false)
	private Bioskop bioskop;
	
	@OneToMany
	private Set<Projekcija> projekcije;
	
	public Repertoar() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}

	public Set<Projekcija> getProjekcije() {
		return projekcije;
	}

	public void setProjekcije(Set<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
	
}
