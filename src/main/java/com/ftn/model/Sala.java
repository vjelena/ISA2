package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sala implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int brojSale;
	
	@Column(nullable = false)
	private int brojMesta;
	
	@Column(nullable = true)
	private String konfiguracija;
	
	public String getKonfiguracija() {
		return konfiguracija;
	}

	public void setKonfiguracija(String konfiguracija) {
		this.konfiguracija = konfiguracija;
	}

	@ManyToOne(optional = false)
	@JsonBackReference
	private Bioskop bioskop;
	
	@ManyToOne(optional = false)
	@JsonBackReference
	private Projekcija projekcija;
		
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

	public int getBrojSale() {
		return brojSale;
	}

	public void setBrojSale(int brojSale) {
		this.brojSale = brojSale;
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
	
}
