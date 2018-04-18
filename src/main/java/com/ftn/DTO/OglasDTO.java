package com.ftn.DTO;

import java.sql.Date;

public class OglasDTO {

	private String naziv;
	private String opis;
	private Date datum; 
	private String slika;
	private String cena;
	private Long korisnikId;
	
	public OglasDTO(){
		
	}

	public OglasDTO(String naziv, String opis, Date datum, String slika,
			String cena, Long korisnikId) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.datum = datum;
		this.slika = slika;
		this.cena = cena;
		this.korisnikId = korisnikId;
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

	public Long getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	
	
}
