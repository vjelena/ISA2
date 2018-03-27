package com.ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IzvestajOPoslovanju implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private float ocenaAmbijenta;
	
	@Column(nullable = false)
	private float ocenaProjekcije;
	
	//graficki prikaz posecenosti
	
	@Column(nullable = false)
	private float prihod;
	
	@OneToOne(optional = false)
	private Bioskop bioskop;
	
	public IzvestajOPoslovanju() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getOcenaAmbijenta() {
		return ocenaAmbijenta;
	}

	public void setOcenaAmbijenta(float ocenaAmbijenta) {
		this.ocenaAmbijenta = ocenaAmbijenta;
	}

	public float getOcenaProjekcije() {
		return ocenaProjekcije;
	}

	public void setOcenaProjekcije(float ocenaProjekcije) {
		this.ocenaProjekcije = ocenaProjekcije;
	}

	public float getPrihod() {
		return prihod;
	}

	public void setPrihod(float prihod) {
		this.prihod = prihod;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}
	
}
