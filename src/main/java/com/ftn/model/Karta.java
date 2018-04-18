package com.ftn.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Karta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	//@JsonIgnore
	//@JsonManagedReference
	private Sediste sediste;
	
	@ManyToOne(optional = false)
	private Projekcija projekcija;
	
	@Column(nullable = false, columnDefinition="boolean default 0")
	private boolean kartaSPopustom;	
	
	@Column(nullable = false, columnDefinition="float default 0")
	private Float popust;
	
	@Column(nullable = false, columnDefinition="boolean default 0")
	private boolean kupljena;	
	
	//@Column(nullable = false)
	//private Date datum;
	
	//@JsonBackReference //da se izbegne rekurzija prilikom snimanja u bazu
	//@ManyToOne(optional = false)
	//private Bioskop bioskop;
	
	//@ManyToOne(optional = false)
	//private Sala sala;
	
	//@ManyToOne(optional = false)
	//private Termin termin;
	
	//@ManyToOne(optional = false)
	//private Rezervacija rezervacija;
	
	//public Rezervacija getRezervacija() {
	//	return rezervacija;
	//}

	//public void setRezervacija(Rezervacija rezervacija) {
	//	this.rezervacija = rezervacija;
	//}

	public boolean isKartaSPopustom() {
		return kartaSPopustom;
	}

	public void setKartaSPopustom(boolean kartaSPopustom) {
		this.kartaSPopustom = kartaSPopustom;
	}

	public Float getPopust() {
		return popust;
	}

	public void setPopust(Float popust) {
		this.popust = popust;
	}

	public boolean isKupljena() {
		return kupljena;
	}

	public void setKupljena(boolean kupljena) {
		this.kupljena = kupljena;
	}

	public Sediste getSediste() {
		return sediste;
	}

	public void setSediste(Sediste sediste) {
		this.sediste = sediste;
	}

	public Karta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projekcija getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

}
