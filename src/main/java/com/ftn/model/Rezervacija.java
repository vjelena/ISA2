package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Rezervacija implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@JsonBackReference
	@ManyToOne(optional = false)
	private Korisnik korisnik;
	
	@ManyToOne(optional = false)
	private Bioskop bioskop;
	
	@ManyToOne(optional = false)//da li je ovo suvisno?
	private Projekcija projekcija;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rezervacija")
	private Set<Karta> listaKarta;
	//jquerry za graficki prikaz liste rezervisanih sedista	
	
	public Rezervacija() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}

	public Projekcija getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public Set<Karta> getListaKarta() {
		return listaKarta;
	}

	public void setListaKarta(Set<Karta> listaKarta) {
		this.listaKarta = listaKarta;
	}

}
