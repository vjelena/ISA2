package com.ftn.DTO;

public class RekvizitDTO {

	private String naziv;
	private String opis;
	private String slika;
	private String cena;
	private Long filmId;
	
	public RekvizitDTO(){
		
	}

	public RekvizitDTO(String naziv, String opis, String slika, String cena,
			Long filmId) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.slika = slika;
		this.cena = cena;
		this.filmId = filmId;
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

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	@Override
	public String toString() {
		return "RekvizitDTO [naziv=" + naziv + ", opis=" + opis + ", slika="
				+ slika + ", cena=" + cena + ", filmId=" + filmId + "]";
	}
	
	
}
