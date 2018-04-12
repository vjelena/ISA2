package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Termin implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private float cena;
	
	@ManyToMany
	@JsonBackReference
	private Set<Vreme> vreme;
	
	@ManyToOne(optional = false)
	@JsonBackReference
	private Projekcija projekcija;
	
	public Termin() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Set<Vreme> getVreme() {
		return vreme;
	}

	public void setVreme(Set<Vreme> vreme) {
		this.vreme = vreme;
	}

}
