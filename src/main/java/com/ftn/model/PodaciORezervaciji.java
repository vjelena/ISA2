package com.ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PodaciORezervaciji implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nazivSelektovanogBioskopa;
	
	@Column(nullable = false)
	private String nazivSelektovanogPozorista;

	@Column(nullable = false)
	private String nazivSelektovaneProjekcije;
	
	@Column(nullable = false)
	private String nazivSelektovanogTermina;
	
	@Column(nullable = false)
	private String nazivSelektovaneSale;
	
	@Column(nullable = false)
	private String nazivSelektovanogPrijatelja;
	
	
	
	public PodaciORezervaciji() {
		
	}

	public PodaciORezervaciji(String nazivSelektovanogBioskopa, String nazivSelektovanogPozorista, String nazivSelektovaneProjekcije,
			String nazivSelektovanogTermina, String nazivSelektovaneSale, String nazivSelektovanogPrijatelja) {
		super();
		this.nazivSelektovanogBioskopa = nazivSelektovanogBioskopa;
		this.nazivSelektovanogPozorista = nazivSelektovanogPozorista;
		this.nazivSelektovaneProjekcije = nazivSelektovaneProjekcije;
		this.nazivSelektovanogTermina = nazivSelektovanogTermina;
		this.nazivSelektovaneSale = nazivSelektovaneSale;
		this.nazivSelektovanogPrijatelja = nazivSelektovanogPrijatelja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivSelektovanogBioskopa() {
		return nazivSelektovanogBioskopa;
	}

	public void setNazivSelektovanogBioskopa(String nazivSelektovanogBioskopa) {
		this.nazivSelektovanogBioskopa = nazivSelektovanogBioskopa;
	}

	public String getNazivSelektovanogPozorista() {
		return nazivSelektovanogPozorista;
	}

	public void setNazivSelektovanogPozorista(String nazivSelektovanogPozorista) {
		this.nazivSelektovanogPozorista = nazivSelektovanogPozorista;
	}
	
	public String getNazivSelektovaneProjekcije() {
		return nazivSelektovaneProjekcije;
	}

	public void setNazivSelektovaneProjekcije(String nazivSelektovaneProjekcije) {
		this.nazivSelektovaneProjekcije = nazivSelektovaneProjekcije;
	}

	public String getNazivSelektovanogTermina() {
		return nazivSelektovanogTermina;
	}

	public void setNazivSelektovanogTermina(String nazivSelektovanogTermina) {
		this.nazivSelektovanogTermina = nazivSelektovanogTermina;
	}

	public String getNazivSelektovaneSale() {
		return nazivSelektovaneSale;
	}

	public void setNazivSelektovaneSale(String nazivSelektovaneSale) {
		this.nazivSelektovaneSale = nazivSelektovaneSale;
	}

	public String getNazivSelektovanogPrijatelja() {
		return nazivSelektovanogPrijatelja;
	}

	public void setNazivSelektovanogPrijatelja(String nazivSelektovanogPrijatelja) {
		this.nazivSelektovanogPrijatelja = nazivSelektovanogPrijatelja;
	}
	
}
