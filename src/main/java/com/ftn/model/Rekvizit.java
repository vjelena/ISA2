package com.ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rekvizit implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String opis;
	
	@Column(nullable = true)
	private String slika;
	
	@Column(nullable = false)
	private String cena; 
	
	@Column(nullable = false)
	private int status;			//0 slobodan 1 rezervisan
	
	@ManyToOne(optional = false)
	private Prodavnica prodavnica;
	
	@ManyToOne(optional = false)
	private Film film;
	
	public Rekvizit() {
		
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Prodavnica getProdavnica() {
		return prodavnica;
	}

	public void setProdavnica(Prodavnica prodavnica) {
		this.prodavnica = prodavnica;
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

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
