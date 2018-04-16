package com.ftn.DTO;

public class ProjekcijaDTO {

	private String cena;
	private String bioskopId;
	private String filmId;
	private String salaId;
	private String terminId;

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public String getBioskopId() {
		return bioskopId;
	}

	public void setBioskopId(String bioskopId) {
		this.bioskopId = bioskopId;
	}

	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public String getSalaId() {
		return salaId;
	}

	public void setSalaId(String salaId) {
		this.salaId = salaId;
	}

	public String getTerminId() {
		return terminId;
	}

	public void setTerminId(String terminId) {
		this.terminId = terminId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.cena + " " + this.bioskopId + " " + this.terminId + " " + this.salaId + " " + this.filmId; 
	}

}
