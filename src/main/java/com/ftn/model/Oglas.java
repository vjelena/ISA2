package com.ftn.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Oglas implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String opis;
	
	@Column(nullable = false)
	private Date datum; //do kada je aktivno prikupljanje ponuda
	
	@Column(nullable = true)
	private String slika;
	
	@Column(nullable = false)
	private int cena;
	//licitacija???
	
	@Column(nullable = true)
	private boolean odobren;
	
	/*@OneToOne
	//@JsonBackReference
	private Rekvizit rekvizit;	//oglasen rekvizit
	
	//@JsonBackReference
	@ManyToOne(optional = false)
	private Korisnik korisnik;*/
	
	@ManyToOne(optional = false)
	//@JsonBackReference
	private FanZona fanZona;
	
	public Oglas() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}*/

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public boolean isOdobren() {
		return odobren;
	}

	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	/*public Rekvizit getRekvizit() {
		return rekvizit;
	}

	public void setRekvizit(Rekvizit rekvizit) {
		this.rekvizit = rekvizit;
	}*/

	public FanZona getFanZona() {
		return fanZona;
	}

	public void setFanZona(FanZona fanZona) {
		this.fanZona = fanZona;
	}
	
	
	
}
