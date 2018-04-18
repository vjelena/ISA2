package com.ftn.DTO;



public class BioskopDTO {

	private Long id;
	private String naziv;
	private String opis;
	private String grad;
	private String ulica;
	private String broj;
	private String xKoordinata;
	private String yKoordianta;
	
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
	
	public String getxKoordinata() {
		return xKoordinata;
	}
	public void setxKoordinata(String xKoordinata) {
		this.xKoordinata = xKoordinata;
	}
	public String getyKoordianta() {
		return yKoordianta;
	}
	public void setyKoordianta(String yKoordianta) {
		this.yKoordianta = yKoordianta;
	}
	@Override
	public String toString() {
		return this.grad + " " + this.ulica + " " + this.broj + " " + this.naziv + " " + this.opis + this.yKoordianta ;
	}
		
}
