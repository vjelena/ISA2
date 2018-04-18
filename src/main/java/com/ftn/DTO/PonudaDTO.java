package com.ftn.DTO;

public class PonudaDTO {

	private String cena;
	private Long korisnikId;
	
	public PonudaDTO(){
		
	}

	public PonudaDTO(String cena, Long korisnikId) {
		super();
		this.cena = cena;
		this.korisnikId = korisnikId;
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
