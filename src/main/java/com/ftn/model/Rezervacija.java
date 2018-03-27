package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Rezervacija implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(optional = false)
	private Korisnik korisnik;
	
	@ManyToOne(optional = false)
	private Bioskop bioskop;
	
	@ManyToOne(optional = false)
	private Projekcija projekcija;
	
	@OneToMany
	private Set<Karta> listaKarta;
	
	@OneToMany
	private Set<Mesto> listaMesta;	//jquerry za graficki prikaz
	
	@OneToMany
	private Set<ZahtevZaPrijateljstvo> pozvaniPrijatelji;
	
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

	public Set<Mesto> getListaMesta() {
		return listaMesta;
	}

	public void setListaMesta(Set<Mesto> listaMesta) {
		this.listaMesta = listaMesta;
	}

	public Set<ZahtevZaPrijateljstvo> getPozvaniPrijatelji() {
		return pozvaniPrijatelji;
	}

	public void setPozvaniPrijatelji(Set<ZahtevZaPrijateljstvo> pozvaniPrijatelji) {
		this.pozvaniPrijatelji = pozvaniPrijatelji;
	}
	
}
