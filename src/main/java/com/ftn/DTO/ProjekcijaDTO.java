package com.ftn.DTO;

import javax.persistence.Column;

public class ProjekcijaDTO {
	
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
	
	private String bioskopId;

	public String getBioskopId() {
		return bioskopId;
	}

	public void setBioskopId(String bioskopId) {
		this.bioskopId = bioskopId;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.naziv + " " + this.cena + " " + this.bioskopId;
	}
	
	
	
}
