package com.ftn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int zlatni; //srebrni zlatni bronzani nista
	
	@Column(nullable = false)
	private int srebrni;
	
	@Column(nullable = false)
	private int bronzani;

	@Column(nullable = false)
	private int zlatniPopust;
	
	@Column(nullable = false)
	private int srebrniPopust;
	
	@Column(nullable = false)
	private int bronzaniPopust;
	
	public Skala(){
		
	}

	public Skala(int zlatni, int srebrni, int bronzani, int zlatniPopust, int srebrniPopust,
			int bronzaniPopust) {
		super();
		this.zlatni = zlatni;
		this.srebrni = srebrni;
		this.bronzani = bronzani;
		this.zlatniPopust = zlatniPopust;
		this.srebrniPopust = srebrniPopust;
		this.bronzaniPopust = bronzaniPopust;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	


}
