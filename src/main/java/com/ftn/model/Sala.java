package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sala implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nazivSale;
	
	@Column(nullable = false)
	private int brojMesta;
	
	@Column(nullable = true)
	private String konfiguracija;
	
	@ManyToOne(optional = false)
	@JsonBackReference
	private Bioskop bioskop;
		
	@JsonIgnore
	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sala")
	private Set<Segment> listaSegmenata;
	
	
	public Sala() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNazivSale() {
		return nazivSale;
	}

	public void setNazivSale(String nazivSale) {
		this.nazivSale = nazivSale;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}

	public Set<Segment> getListaSegmenata() {
		return listaSegmenata;
	}

	public void setListaSegmenata(Set<Segment> listaSegmenata) {
		this.listaSegmenata = listaSegmenata;
	}
	public String getKonfiguracija() {
		return konfiguracija;
	}

	public void setKonfiguracija(String konfiguracija) {
		this.konfiguracija = konfiguracija;
	}
	
}
