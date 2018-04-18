package com.ftn.DTO;


public class SalaDTO {
	
	
	private String nazivSale;
	
	
	private int brojMesta;
	
	
	private String konfiguracija;
	
	private String bioskop;
	
	public SalaDTO(){
		
	}

	public SalaDTO(String brojSale, int brojMesta, String konfiguracija, String bioskop) {
		super();
		this.nazivSale = brojSale;
		this.brojMesta = brojMesta;
		this.konfiguracija = konfiguracija;
		this.bioskop = bioskop;
	}

	public String getBrojSale() {
		return nazivSale;
	}

	public void setBrojSale(String brojSale) {
		this.nazivSale = brojSale;
	}


	public int getBrojMesta() {
		return brojMesta;
	}


	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}


	public String getKonfiguracija() {
		return konfiguracija;
	}


	public void setKonfiguracija(String konfiguracija) {
		this.konfiguracija = konfiguracija;
	}

	public String getBioskop() {
		return bioskop;
	}

	public void setBioskop(String bioskop) {
		this.bioskop = bioskop;
	}
	
	
	

}
