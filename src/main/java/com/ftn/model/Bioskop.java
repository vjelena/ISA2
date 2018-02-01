package com.ftn.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Bioskop implements Serializable{
	
	@Column
	private String naziv;
	private String opis;
	private Adresa adresa;
	private Set<Sala> listaSala;
	
	@JsonIgnore //da se izbegne rekurzija pri slanju objekta, stavlja se sa jedne strane vezee, tipa gde je set
	@JsonManagedReference  //sa jedne strane managed a sa druge back
	private Set<Karta> listaKarata;
	
	private Set<BrzaKarta> brzeKarte;
	private Repertoar repertoar;
	private Set<Segment> listaSegmenta;
	
	private IzvestajOPoslovanju izvestaj;
	
	//treba id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

}
