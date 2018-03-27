package com.ftn.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BrzaKarta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonBackReference
	private Bioskop bioskop;
	
	@ManyToOne(optional = false)
	private Projekcija projekcija;
	
	@Column(nullable = false)
	private Date datum;
	
	@ManyToOne(optional = false)
	private Termin termin;
	
	@ManyToOne(optional = false)
	private Sala sala;
	
	@Column(nullable = false)
	private float cenaSaPopustom;
	
	@Column(nullable = false)
	private boolean prodata;
	
	public BrzaKarta() {

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

	public Projekcija getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Termin getTermin() {
		return termin;
	}

	public void setTermin(Termin termin) {
		this.termin = termin;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public float getCenaSaPopustom() {
		return cenaSaPopustom;
	}

	public void setCenaSaPopustom(float cenaSaPopustom) {
		this.cenaSaPopustom = cenaSaPopustom;
	}

	public boolean isProdata() {
		return prodata;
	}

	public void setProdata(boolean prodata) {
		this.prodata = prodata;
	}
	
}
