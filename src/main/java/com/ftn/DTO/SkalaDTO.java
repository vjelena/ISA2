package com.ftn.DTO;


public class SkalaDTO {
	

	private int zlatni; //srebrni zlatni bronzani nista
	

	private int srebrni;
	

	private int bronzani;


	private int zlatniPopust;
	

	private int srebrniPopust;
	

	private int bronzaniPopust;
	
	private String bioskop;
	
	public SkalaDTO(){
		
	}

	public SkalaDTO(int zlatni, int srebrni, int bronzani, int zlatniPopust, int srebrniPopust, int bronzaniPopust, String bioskop) {
		super();
		this.zlatni = zlatni;
		this.srebrni = srebrni;
		this.bronzani = bronzani;
		this.zlatniPopust = zlatniPopust;
		this.srebrniPopust = srebrniPopust;
		this.bronzaniPopust = bronzaniPopust;
		this.bioskop = bioskop;
	}

	public int getZlatni() {
		return zlatni;
	}

	public void setZlatni(int zlatni) {
		this.zlatni = zlatni;
	}

	public int getSrebrni() {
		return srebrni;
	}

	public void setSrebrni(int srebrni) {
		this.srebrni = srebrni;
	}

	public int getBronzani() {
		return bronzani;
	}

	public void setBronzani(int bronzani) {
		this.bronzani = bronzani;
	}

	public int getZlatniPopust() {
		return zlatniPopust;
	}

	public void setZlatniPopust(int zlatniPopust) {
		this.zlatniPopust = zlatniPopust;
	}

	public int getSrebrniPopust() {
		return srebrniPopust;
	}

	public void setSrebrniPopust(int srebrniPopust) {
		this.srebrniPopust = srebrniPopust;
	}

	public int getBronzaniPopust() {
		return bronzaniPopust;
	}

	public void setBronzaniPopust(int bronzaniPopust) {
		this.bronzaniPopust = bronzaniPopust;
	}

	public String getBioskop() {
		return bioskop;
	}

	public void setBioskop(String bioskop) {
		this.bioskop = bioskop;
	}

	@Override
	public String toString() {
		return "SkalaDTO [zlatni=" + zlatni + ", srebrni=" + srebrni + ", bronzani=" + bronzani + ", zlatniPopust="
				+ zlatniPopust + ", srebrniPopust=" + srebrniPopust + ", bronzaniPopust=" + bronzaniPopust
				+ ", bioskop=" + bioskop + "]";
	}
	
	
	
	

}
