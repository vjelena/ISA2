package com.ftn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZahtevZaPrijateljstvo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Korisnik posiljalac;
	private Korisnik primalac;
	
	@Column(nullable = false)
	private boolean prihvatio;
	
	public ZahtevZaPrijateljstvo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Korisnik getPosiljalac() {
		return posiljalac;
	}

	public void setPosiljalac(Korisnik posiljalac) {
		this.posiljalac = posiljalac;
	}

	public Korisnik getPrimalac() {
		return primalac;
	}

	public void setPrimalac(Korisnik primalac) {
		this.primalac = primalac;
	}

	public boolean isPrihvatio() {
		return prihvatio;
	}

	public void setPrihvatio(boolean prihvatio) {
		this.prihvatio = prihvatio;
	}
	
}
