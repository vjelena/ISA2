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
import javax.persistence.OneToOne;

@Entity
public class Korisnik implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String lozinka;
	
	@Column(nullable = false)
	private String brojTelefona;
	
	@ManyToOne(optional = false)
	private Adresa adresa;
	private Grad grad;	// da li mu je potreban grad ako u adresi imamo grad
	
	@Column(nullable = false)
	private String uloga;
	
	@Column(nullable = false)
	private float ocenaAmbijenta;
	
	@Column(nullable = false)
	private float ocenaProjekcije;
	
	
	private Set<ZahtevZaPrijateljstvo> listaZahtevaZaPrijateljstvo;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "korisnik")
	private Set<Rezervacija> listaRezervacija;
	
	@OneToOne(optional = false)
	private Set<Rekvizit> listaRekvizita;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "korisnik")
	private Set<Oglas> listaOglasa;
	
	@ManyToOne(optional = false)
	private Clan clan;
	
	public Korisnik() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public float getOcenaAmbijenta() {
		return ocenaAmbijenta;
	}

	public void setOcenaAmbijenta(float ocenaAmbijenta) {
		this.ocenaAmbijenta = ocenaAmbijenta;
	}

	public float getOcenaProjekcije() {
		return ocenaProjekcije;
	}

	public void setOcenaProjekcije(float ocenaProjekcije) {
		this.ocenaProjekcije = ocenaProjekcije;
	}

	public Set<ZahtevZaPrijateljstvo> getListaZahtevaZaPrijateljstvo() {
		return listaZahtevaZaPrijateljstvo;
	}

	public void setListaZahtevaZaPrijateljstvo(Set<ZahtevZaPrijateljstvo> listaZahtevaZaPrijateljstvo) {
		this.listaZahtevaZaPrijateljstvo = listaZahtevaZaPrijateljstvo;
	}

	public Set<Rezervacija> getListaRezervacija() {
		return listaRezervacija;
	}

	public void setListaRezervacija(Set<Rezervacija> listaRezervacija) {
		this.listaRezervacija = listaRezervacija;
	}

	public Set<Rekvizit> getListaRekvizita() {
		return listaRekvizita;
	}

	public void setListaRekvizita(Set<Rekvizit> listaRekvizita) {
		this.listaRekvizita = listaRekvizita;
	}

	public Set<Oglas> getListaOglasa() {
		return listaOglasa;
	}

	public void setListaOglasa(Set<Oglas> listaOglasa) {
		this.listaOglasa = listaOglasa;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}
	
}

