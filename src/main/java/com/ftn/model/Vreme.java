package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Vreme implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String vreme;
	
	@ManyToMany
	@JsonIgnore
	//@JsonManagedReference
	private Set<Termin> listaTermina;
	
	public Vreme() {
		
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Set<Termin> getListaTermina() {
		return listaTermina;
	}

	public void setListaTermina(Set<Termin> listaTermina) {
		this.listaTermina = listaTermina;
	}
	
}
