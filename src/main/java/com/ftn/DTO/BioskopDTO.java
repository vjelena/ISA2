package com.ftn.DTO;

import com.ftn.model.Adresa;
import com.ftn.model.Repertoar;

public class BioskopDTO {

	private int id;
	private String naziv;
	private String opis;
	private Repertoar repertoar;
	private Adresa adresa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Repertoar getRepertoar() {
		return repertoar;
	}
	public void setRepertoar(Repertoar repertoar) {
		this.repertoar = repertoar;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
		
}
