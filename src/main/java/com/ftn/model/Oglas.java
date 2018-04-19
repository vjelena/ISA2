package com.ftn.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String cena;
	
	@Column(nullable = false)
	private int status;		//0 neodobren 1 odobren
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "oglas")
	@JsonIgnore
	private List<Ponuda> listaPonuda;
	
	@ManyToOne(optional = false)
	private Korisnik korisnik;
	
	@ManyToOne(optional = false)
	private FanZona fanZona;
	
	public Oglas() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	public List<Ponuda> getListaPonuda() {
		return listaPonuda;
	}

	public void setListaPonuda(List<Ponuda> listaPonuda) {
		this.listaPonuda = listaPonuda;
	}

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

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}
	
	public FanZona getFanZona() {
		return fanZona;
	}

	public void setFanZona(FanZona fanZona) {
		this.fanZona = fanZona;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
