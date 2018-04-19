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
	private Long id;

	@ManyToOne(optional = false)
	private Korisnik korisnikKojiJeIzvrsioRezervaciju;
	
	@ManyToOne(optional = false)
	private Bioskop bioskop;
	
	@ManyToOne(optional = false)//da li je ovo suvisno?
	private Projekcija projekcija;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "rezervacija")
	//private Set<Karta> listaKarta;
	//jquerry za graficki prikaz liste rezervisanih sedista	
	
	public Rezervacija() {
		
	}

	public Rezervacija(Korisnik korisnikKojiJeIzvrsioRezervaciju, Bioskop bioskop, Projekcija projekcija) {
		super();
		this.korisnikKojiJeIzvrsioRezervaciju = korisnikKojiJeIzvrsioRezervaciju;
		this.bioskop = bioskop;
		this.projekcija = projekcija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getKorisnikKojiJeIzvrsioRezervaciju() {
		return korisnikKojiJeIzvrsioRezervaciju;
	}

	public void setKorisnikKojiJeIzvrsioRezervaciju(Korisnik korisnikKojiJeIzvrsioRezervaciju) {
		this.korisnikKojiJeIzvrsioRezervaciju = korisnikKojiJeIzvrsioRezervaciju;
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
/*
	public Set<Karta> getListaKarta() {
		return listaKarta;
	}

	public void setListaKarta(Set<Karta> listaKarta) {
		this.listaKarta = listaKarta;
	}*/

}
