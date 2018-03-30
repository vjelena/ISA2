package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class FanZona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fanZona")
	@JsonIgnore
	@JsonManagedReference
	private Set<Oglas> listaOglasa;
	
	@OneToOne
	@JsonBackReference
	private Bioskop bioskop;
	
	public FanZona() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Oglas> getListaOglasa() {
		return listaOglasa;
	}

	public void setListaOglasa(Set<Oglas> listaOglasa) {
		this.listaOglasa = listaOglasa;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}
	
}
