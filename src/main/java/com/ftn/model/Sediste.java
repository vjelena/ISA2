package com.ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Sediste implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int red;

	@Column(nullable = false)
	private int kolona;
	
	//@OneToOne
	//@JsonBackReference
	//private Karta karta;
	
	@ManyToOne(optional = false)
	@JsonBackReference
	private Sala sala;
	
	public Sediste() {
		
	}

	public Sediste(int red, int kolona, Sala sala) {
		super();
		this.red = red;
		this.kolona = kolona;
		this.sala = sala;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getKolona() {
		return kolona;
	}

	public void setKolona(int kolona) {
		this.kolona = kolona;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	

	/*public Karta getKarta() {
		return karta;
	}

	public void setKarta(Karta karta) {
		this.karta = karta;
	}*/

	/*public Segment getSegment() {
		return segment;
	}

	public void setSegment(Segment segment) {
		this.segment = segment;
	}*/

}
