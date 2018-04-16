package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Projekcija implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	
	@Column(nullable = false)
	private float cena;
	
	//@JsonIgnore
	@OneToOne
	private Sala sala;     
	
	//@JsonIgnore
	@OneToOne
	private Termin termin;
	
	@ManyToMany
	//@JsonIgnore
	//@JsonManagedReference
	private Set<Glumac> glumci;
	
	//@JsonIgnore
	@ManyToOne(optional = false)
	@JsonBackReference(value="repertoar")
	private Repertoar repertoar;
	
	public Repertoar getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(Repertoar repertoar) {
		this.repertoar = repertoar;
	}

	public Projekcija() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Termin getTermin() {
		return termin;
	}

	public void setTermini(Termin termin) {
		this.termin = termin;
	}


	
	
}
