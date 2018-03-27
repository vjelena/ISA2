package com.ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int brojSale;
	
	@Column(nullable = false)
	private int brojMesta;
	
	//lista mesta?
	
	public Sala() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrojSale() {
		return brojSale;
	}

	public void setBrojSale(int brojSale) {
		this.brojSale = brojSale;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}
	
}
