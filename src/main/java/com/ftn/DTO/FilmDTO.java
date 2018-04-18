package com.ftn.DTO;


public class FilmDTO {
	
	private String naziv;
	
	private String zanr;
	
	private String reditelj;
	
	private String opis;
	
	private String slika;
	
	private int trajanje;
	
	private float ocena;
	
	private String glumacId;

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

	public String getGlumacId() {
		return glumacId;
	}

	public void setGlumacId(String glumacId) {
		this.glumacId = glumacId;
	}
	
	

}
