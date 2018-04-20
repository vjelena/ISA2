package com.ftn.DTO;


public class KorisnikAdminDTO {

	private String email;
	private String lozinka;
	private String ime;
	private String prezime;
	private String grad;
	private String ulica;
	private String broj;
	private String brojTelefona;
	private String uloga;
	private String bioskop;
	
	public KorisnikAdminDTO() {
		super();
	}

	public KorisnikAdminDTO(String email, String lozinka, String ime,
			String prezime, String grad, String ulica, String broj,
			String brojTelefona, String uloga, String bioskop) {
		super();
		this.email = email;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.grad = grad;
		this.ulica = ulica;
		this.broj = broj;
		this.brojTelefona = brojTelefona;
		this.uloga = uloga;
		this.bioskop = bioskop;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

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

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}



	public String getBioskop() {
		return bioskop;
	}

	public void setBioskop(String bioskop) {
		this.bioskop = bioskop;
	}

	@Override
	public String toString() {
		return "KorisnikAdminDTO [email=" + email + ", lozinka=" + lozinka
				+ ", ime=" + ime + ", prezime=" + prezime + ", grad=" + grad
				+ ", ulica=" + ulica + ", broj=" + broj + ", brojTelefona="
				+ brojTelefona + ", uloga=" + uloga + ", bioskopId="
				+ bioskop + "]";
	}

	
}
