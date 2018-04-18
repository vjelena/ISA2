package com.ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class IzvestajOPoslovanjuPozoriste implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private float prosecnaOcenaAmbijenta;
	
	@Column(nullable = false)
	private float prosecnaOcenaProjekcije;
	
	//graficki prikaz posecenosti
	
	@Column(nullable = false)
	private float prihod;
	
	@OneToOne(optional = false)
	@JsonBackReference
	private Pozoriste pozoriste;
	
	public IzvestajOPoslovanjuPozoriste() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPrihod() {
		return prihod;
	}

	public void setPrihod(float prihod) {
		this.prihod = prihod;
	}

	

	public Pozoriste getPozoriste() {
		return pozoriste;
	}

	public void setPozoriste(Pozoriste pozoriste) {
		this.pozoriste = pozoriste;
	}

	public float getProsecnaOcenaAmbijenta() {
		return prosecnaOcenaAmbijenta;
	}

	public void setProsecnaOcenaAmbijenta(float prosecnaOcenaAmbijenta) {
		this.prosecnaOcenaAmbijenta = prosecnaOcenaAmbijenta;
	}

	public float getProsecnaOcenaProjekcije() {
		return prosecnaOcenaProjekcije;
	}

	public void setProsecnaOcenaProjekcije(float prosecnaOcenaProjekcije) {
		this.prosecnaOcenaProjekcije = prosecnaOcenaProjekcije;
	}
	
	
	
}
