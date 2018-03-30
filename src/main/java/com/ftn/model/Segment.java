package com.ftn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Segment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String tipSegmenta; //balkon, vip sedista..
	
	@Column(nullable = false)
	private boolean zatvoreno;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "segment")
	@JsonIgnore
	@JsonManagedReference
	private Set<Sediste> listaSedista;
	
	@JsonBackReference
	@ManyToOne(optional = false)
	private Sala sala;
	
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

	public boolean isZatvoreno() {
		return zatvoreno;
	}

	public void setZatvoreno(boolean zatvoreno) {
		this.zatvoreno = zatvoreno;
	}

	public Set<Sediste> getListaSedista() {
		return listaSedista;
	}

	public void setListaSedista(Set<Sediste> listaSedista) {
		this.listaSedista = listaSedista;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
