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
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String lozinka;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@OneToOne(optional = false)
	private Adresa adresa;
	
	@Column(nullable = false)
	private String brojTelefona;
	
	@Column(nullable = false)
	private String uloga;
	
	@Column(nullable = false)
	private boolean aktiviranNalogPrekoMejla;
	
	@Column(nullable = false)
	private boolean prviPutSeUlogovao; //za sesiju (da bismo znali koji je korisnik trenutno ulogovan)
	
	
	public Korisnik() {
		
	}

	public Korisnik(String email, String lozinka, String ime, String prezime, Adresa adresa,
			String brojTelefona, String uloga, boolean aktiviranNalogPrekoMejla, boolean prviPutSeUlogovao) {
		super();
		this.email = email;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.uloga = uloga;
		this.aktiviranNalogPrekoMejla = aktiviranNalogPrekoMejla;
		this.prviPutSeUlogovao = prviPutSeUlogovao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public boolean isAktiviranNalogPrekoMejla() {
		return aktiviranNalogPrekoMejla;
	}

	public void setAktiviranNalogPrekoMejla(boolean aktiviranNalogPrekoMejla) {
		this.aktiviranNalogPrekoMejla = aktiviranNalogPrekoMejla;
	}

	public boolean isPrviPutSeUlogovao() {
		return prviPutSeUlogovao;
	}

	public void setPrviPutSeUlogovao(boolean prviPutSeUlogovao) {
		this.prviPutSeUlogovao = prviPutSeUlogovao;
	}

}

