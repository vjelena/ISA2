package com.ftn.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class RepertoarPozorista implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(optional = false)
	@JsonBackReference
	private Pozoriste pozoriste;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "repertoarPozorista")
	//@JsonIgnore
	//@JsonManagedReference
	private List<ProjekcijaPozorista> projekcijePozorista;
	
	public RepertoarPozorista() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}

	public void setPozoriste(Pozoriste pozoriste) {
		this.pozoriste = pozoriste;
	}

	public List<ProjekcijaPozorista> getProjekcijePozorista() {
		return projekcijePozorista;
	}

	public void setProjekcijePozorista(List<ProjekcijaPozorista> projekcijePozorista) {
		this.projekcijePozorista = projekcijePozorista;
	}

	
}
