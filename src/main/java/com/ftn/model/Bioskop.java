package com.ftn.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Bioskop implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String opis;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Adresa adresa;
	
	//@JsonIgnore //u modelu nam ne trebaju anotacije JsonIgnore(to ide u DTO) i JsonManageReference
//	@JsonManagedReference
	@OneToMany
	private Set<Sala> listaSala;
		
	//@JsonIgnore //da se izbegne rekurzija pri slanju objekta, stavlja se sa jedne strane veze, tipa gde je set
//	@JsonManagedReference  //sa jedne strane managed a sa druge back
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bioskop")
	private Set<Karta> listaKarata;
	
	//@JsonIgnore
//	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bioskop")
	private Set<BrzaKarta> brzeKarte;
	
	//@JsonIgnore
//	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bioskop")//bidirekciona veza 1:1, vlasnik veze je bioskop(naziv kolone u tabeli repertoar)
	private Repertoar repertoar;

	//@JsonIgnore
//	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bioskop")
	private IzvestajOPoslovanju izvestaj;
	
	//@JsonIgnore
//	@JsonManagedReference
	@ManyToMany
	private Set<Korisnik> listaPosetilaca;
	
	//@JsonIgnore
//	@JsonManagedReference
	@OneToOne
	private FanZona fanZona;
	
	@Column(nullable = false)
	private float prosecnaOcena;

	
	public Bioskop() {
		
	}
	
	public Bioskop(String naziv, String opis) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Set<Sala> getListaSala() {
		return listaSala;
	}

	public void setListaSala(Set<Sala> listaSala) {
		this.listaSala = listaSala;
	}

	public Set<Karta> getListaKarata() {
		return listaKarata;
	}

	public void setListaKarata(Set<Karta> listaKarata) {
		this.listaKarata = listaKarata;
	}

	public Set<BrzaKarta> getBrzeKarte() {
		return brzeKarte;
	}

	public void setBrzeKarte(Set<BrzaKarta> brzeKarte) {
		this.brzeKarte = brzeKarte;
	}

	public Repertoar getRepertoar() {
		return repertoar;
	}

	public void setRepertoar(Repertoar repertoar) {
		this.repertoar = repertoar;
	}

	public IzvestajOPoslovanju getIzvestaj() {
		return izvestaj;
	}

	public void setIzvestaj(IzvestajOPoslovanju izvestaj) {
		this.izvestaj = izvestaj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(float prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public Set<Korisnik> getListaPosetilaca() {
		return listaPosetilaca;
	}

	public void setListaPosetilaca(Set<Korisnik> listaPosetilaca) {
		this.listaPosetilaca = listaPosetilaca;
	}

	public FanZona getFanZona() {
		return fanZona;
	}

	public void setFanZona(FanZona fanZona) {
		this.fanZona = fanZona;
	}

	
	
}
