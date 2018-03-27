package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Segment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String tipSegmenta; //balkon, vip sedista..
	
	@OneToMany
	private Set<Mesto> listaMesta;
	
	@Column(nullable = false)
	private boolean zatvoreno;
	
	public Segment() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipSegmenta() {
		return tipSegmenta;
	}

	public void setTipSegmenta(String tipSegmenta) {
		this.tipSegmenta = tipSegmenta;
	}

	public Set<Mesto> getListaMesta() {
		return listaMesta;
	}

	public void setListaMesta(Set<Mesto> listaMesta) {
		this.listaMesta = listaMesta;
	}

	public boolean isZatvoreno() {
		return zatvoreno;
	}

	public void setZatvoreno(boolean zatvoreno) {
		this.zatvoreno = zatvoreno;
	}
	
}
