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
public class Korisnik implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String lozinka;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@Column(nullable = false)
	private String brojTelefona;
	
	@Column(nullable = false)
	private String uloga;
	
	@Column(nullable = false)
	private Boolean aktiviranNalog; //slanje mejla za aktivaciju korisnickog naloga

	@Column(nullable = false)
	private float ocenaProjekcije;
	
	@Column(nullable = false)
	private float ocenaAmbijenta;
	
	@OneToOne(optional = false)
	private Adresa adresa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posiljalac")
	@JsonIgnore
	//@JsonManagedReference
	private Set<PoslatZahtev> listaPoslatihZahteva;
	//pitati za brisanje prijatelja sta se onda desava, kako obavestiti obrisanog
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "primalac")
	@JsonIgnore
	//@JsonManagedReference
	private Set<PrihvacenZahtev> listaPrihvacenihZahteva;
	
	@JsonIgnore
	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "korisnik")
	private Set<Rezervacija> listaRezervacija;
	
	/*@JsonIgnore
	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "korisnik")
	private Set<Oglas> listaOglasa;*/
	
	@OneToOne(optional = false)
	private Clan clan;
	
	@ManyToMany
	//@JsonBackReference
	private Set<Bioskop> listaPosecenihBioskopa;
	
	public Korisnik() {
		
	}

	public Korisnik(String ime, String prezime, String email, String lozinka, String brojTelefona, Adresa adresa, Boolean aktiviranNalog) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.brojTelefona = brojTelefona;
		this.adresa = adresa;
		this.aktiviranNalog = aktiviranNalog;
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

	public Set<Rezervacija> getListaRezervacija() {
		return listaRezervacija;
	}

	public void setListaRezervacija(Set<Rezervacija> listaRezervacija) {
		this.listaRezervacija = listaRezervacija;
	}

	/*public Set<Oglas> getListaOglasa() {
		return listaOglasa;
	}

	public void setListaOglasa(Set<Oglas> listaOglasa) {
		this.listaOglasa = listaOglasa;
	}*/

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Set<PoslatZahtev> getListaPoslatihZahteva() {
		return listaPoslatihZahteva;
	}

	public void setListaPoslatihZahteva(Set<PoslatZahtev> listaPoslatihZahteva) {
		this.listaPoslatihZahteva = listaPoslatihZahteva;
	}

	public Set<PrihvacenZahtev> getListaPrihvacenihZahteva() {
		return listaPrihvacenihZahteva;
	}

	public void setListaPrihvacenihZahteva(Set<PrihvacenZahtev> listaPrihvacenihZahteva) {
		this.listaPrihvacenihZahteva = listaPrihvacenihZahteva;
	}

	public Set<Bioskop> getListaPosecenihBioskopa() {
		return listaPosecenihBioskopa;
	}

	public void setListaPosecenihBioskopa(Set<Bioskop> listaPosecenihBioskopa) {
		this.listaPosecenihBioskopa = listaPosecenihBioskopa;
	}
	
	public Boolean getAktiviranNalog() {
		return aktiviranNalog;
	}

	public void setAktiviranNalog(Boolean aktiviranNalog) {
		this.aktiviranNalog = aktiviranNalog;
	}
	
}

