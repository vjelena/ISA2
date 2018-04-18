package com.ftn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pozoriste implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private String opis;
	
	@Column(nullable = false)
	private String xKoordinata;
	
	@Column(nullable = false)
	private String yKoordinata;
	
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Adresa adresa;
	
	
	//@JsonIgnore //u modelu nam ne trebaju anotacije JsonIgnore(to ide u DTO) i JsonManageReference
//	@JsonManagedReference
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Set<Sala> listaSala;
		
	//@JsonIgnore //da se izbegne rekurzija pri slanju objekta, stavlja se sa jedne strane veze, tipa gde je set
//	@JsonManagedReference  //sa jedne strane managed a sa druge back
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "bioskop")
	//private Set<Karta> listaKarata;
	
	//@JsonIgnore
//	@JsonManagedReference
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "bioskop")
	//private Set<BrzaKarta> brzeKarte;
	
	//@JsonIgnore
//	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pozoriste")
	private RepertoarPozorista repertoarPozorista;

	//@JsonIgnore
//	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pozoriste")
	private IzvestajOPoslovanjuPozoriste izvestajPozoriste;
	
	//@JsonIgnore
//	@JsonManagedReference
	@OneToOne
	private FanZona fanZona;
	
	@Column(nullable = false)
	private float prosecnaOcena;
	
	//istorija poseta pozoristima
	@ManyToMany
	@JoinTable(name = "korisnikovaIstorijaPosetaPozoristima", joinColumns = { @JoinColumn(name = "posecenoPozoriste", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "posetilac") })
	@JsonIgnore
	List<Korisnik> posetiociPozorista;


	public Pozoriste() {
		
	}
	
	public Pozoriste(String naziv, String opis, Adresa adresa, float prosecnaOcena) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.adresa = adresa;
		this.prosecnaOcena = prosecnaOcena;
	}

	public Pozoriste(String naziv, String opis) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.posetiociPozorista = new ArrayList<Korisnik>();
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

	@OneToMany(mappedBy = "pozoriste", cascade = CascadeType.ALL)
	public Set<Sala> getListaSala() {
		return listaSala;
	}

	public void setListaSala(Set<Sala> listaSala) {
		this.listaSala = listaSala;
	}

	/*public Set<Karta> getListaKarata() {
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
*/
	public RepertoarPozorista getRepertoarPozorista() {
		return repertoarPozorista;
	}

	public void setRepertoarPozorista(RepertoarPozorista repertoarPozorista) {
		this.repertoarPozorista = repertoarPozorista;
	}



	public IzvestajOPoslovanjuPozoriste getIzvestajPozoriste() {
		return izvestajPozoriste;
	}

	public void setIzvestajPozoriste(IzvestajOPoslovanjuPozoriste izvestajPozoriste) {
		this.izvestajPozoriste = izvestajPozoriste;
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

	public FanZona getFanZona() {
		return fanZona;
	}

	public void setFanZona(FanZona fanZona) {
		this.fanZona = fanZona;
	}
	
	public List<Korisnik> getPosetiociPozorista() {
		return posetiociPozorista;
	}

	public void setPosetiociPozorista(List<Korisnik> posetiociPozorista) {
		this.posetiociPozorista = posetiociPozorista;
	}	

	public String getxKoordinata() {
		return xKoordinata;
	}

	public void setxKoordinata(String xKoordinata) {
		this.xKoordinata = xKoordinata;
	}

	public String getyKoordinata() {
		return yKoordinata;
	}

	public void setyKoordinata(String yKoordinata) {
		this.yKoordinata = yKoordinata;
	}
	
	
}
