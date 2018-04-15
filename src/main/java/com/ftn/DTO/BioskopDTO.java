package com.ftn.DTO;

import com.ftn.model.Adresa;
import com.ftn.model.Repertoar;

public class BioskopDTO {

	private int id;
	private String naziv;
	private String opis;
	private String grad;
	private String ulica;
	private String broj;
	
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
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
	
	@Override
	public String toString() {
		return this.broj + " " + this.grad + " " + this.naziv + " " + this.opis;
	}
		
}
