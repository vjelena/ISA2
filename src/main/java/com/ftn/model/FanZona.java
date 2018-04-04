package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FanZona implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String naziv;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fanZona")
	@JsonIgnore
	//@JsonManagedReference
	private Set<Oglas> listaOglasa;
	
	public FanZona() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Set<Oglas> getListaOglasa() {
		return listaOglasa;
	}

	public void setListaOglasa(Set<Oglas> listaOglasa) {
		this.listaOglasa = listaOglasa;
	}
	
}
