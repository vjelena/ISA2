package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@Column(nullable = false)
	private String slika;
	
	@Column(nullable = false)
	private int trajanje;
	
	@Column(nullable = false)
	private float ocena;
	
	@OneToMany 
	private Set<Sala> sale;
	//????
	//@OneToMany ?
	//private Set<Termin> termini;
	
	@ManyToMany
	//@JsonIgnore
	//@JsonManagedReference
	private Set<Glumac> glumci;
	
	@ManyToOne(optional = false)
	//@JsonBackReference
	private Repertoar repertoar;
	
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

	public Set<Glumac> getGlumci() {
		return glumci;
	}

	public void setGlumci(Set<Glumac> glumci) {
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

	/*public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}

	public Set<Termin> getTermini() {
		return termini;
	}

	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}*/
	
}
