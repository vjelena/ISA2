package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Projekcija implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String zanr;
	
	@Column(nullable = false)
	private String reditelj;
	
	@Column(nullable = false)
	private String opis;
	
	@Column(nullable = false) //?
	private Set<String> glumci;
	
	@Column(nullable = false)
	private String slika;
	
	@Column(nullable = false)
	private int trajanje;
	
	@Column(nullable = false)
	private float ocena;
	
	@OneToMany
	private Set<Sala> sale;
	
	@Column(nullable = false)
	private float cena;
	
	@OneToMany
	private Set<Termin> termini;
	
	public Projekcija() {
		
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

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getReditelj() {
		return reditelj;
	}

	public void setReditelj(String reditelj) {
		this.reditelj = reditelj;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<String> getGlumci() {
		return glumci;
	}

	public void setGlumci(Set<String> glumci) {
		this.glumci = glumci;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public float getOcena() {
		return ocena;
	}

	public void setOcena(float ocena) {
		this.ocena = ocena;
	}

	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Set<Termin> getTermini() {
		return termini;
	}

	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}
	
}
