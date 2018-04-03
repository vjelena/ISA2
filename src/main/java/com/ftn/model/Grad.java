package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Grad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany		//?
	@JsonIgnore
	private Set<Bioskop> listaBioskopa;
	
	public Grad() {
		
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

	public Set<Bioskop> getListaBioskopa() {
		return listaBioskopa;
	}

	public void setListaBioskopa(Set<Bioskop> listaBioskopa) {
		this.listaBioskopa = listaBioskopa;
	}
	
}
