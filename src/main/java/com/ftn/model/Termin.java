package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Termin implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private float cena;
	
	@Column(nullable = false) //?
	private Set<String> satnica;
	
	public Termin() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Set<String> getSatnica() {
		return satnica;
	}

	public void setSatnica(Set<String> satnica) {
		this.satnica = satnica;
	}
	
}
