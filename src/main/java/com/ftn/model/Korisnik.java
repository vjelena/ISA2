package com.ftn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Korisnik implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String lozinka;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@OneToOne(optional = false)
	private Adresa adresa;
	
	@Column(nullable = false)
	private String brojTelefona;
	
	@Column(nullable = false)
	private String uloga;
	
	@Column(nullable = false)
	private boolean aktiviranNalogPrekoMejla;
	
	@Column(nullable = false)
	private boolean prviPutSeUlogovao;
	
	@Column(nullable = false)
	private int brojPoseta; //za odredjivanje vrste clana
	
	@Column(nullable = false)
	private String vrstaClana;

	@ManyToOne(optional = true)
	private FanZona fanZonaAdmin;

	//deo za prijatelje
	@ManyToMany
	@JoinTable(name = "mojiPrijatelji", joinColumns = @JoinColumn(name = "id_k1", nullable = false), inverseJoinColumns = @JoinColumn(name = "id_k2", nullable = false))
	@JsonIgnore
	private List<Korisnik> mojiPrijatelji;

	@ManyToMany(mappedBy = "mojiPrijatelji")
	@JsonIgnore
	private List<Korisnik> komeSamJaPrijatelj;

	@ManyToMany
	@JoinTable(name = "zahteviZaPrijateljstvo", joinColumns = @JoinColumn(name = "koJePrimioZahtev", nullable = false), inverseJoinColumns = @JoinColumn(name = "koJePoslaoZahtev", nullable = false))
	@JsonIgnore
	private List<Korisnik> zahteviZaPrijateljstvo;
	
	//istorija poseta bioskopima
	@ManyToMany(mappedBy = "posetioci")
	@JsonIgnore
    List<Bioskop> poseceniBioskopi;
	
	//istorija poseta pozoristima
	@ManyToMany(mappedBy = "posetiociPozorista")
	@JsonIgnore
	List<Pozoriste> posecenaPozorista;
	
	/*//obicne rezervacije mesta u bioskopu
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "korisnik")
	//@JsonIgnore
	List<ObicnaRezervacija> listaObicnihRezervacija;*/
	

	public Korisnik() {
		
	}

	public Korisnik(String email, String lozinka, String ime, String prezime, Adresa adresa,
			String brojTelefona, String uloga, boolean aktiviranNalogPrekoMejla, boolean prviPutSeUlogovao, String vrstaClana) {
		super();
		this.email = email;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.uloga = uloga;
		this.aktiviranNalogPrekoMejla = aktiviranNalogPrekoMejla;
		this.prviPutSeUlogovao = prviPutSeUlogovao;
		this.vrstaClana = vrstaClana;
		this.mojiPrijatelji = new ArrayList<Korisnik>();
		this.komeSamJaPrijatelj = new ArrayList<Korisnik>();
		this.zahteviZaPrijateljstvo = new ArrayList<Korisnik>();
		this.poseceniBioskopi = new ArrayList<Bioskop>();
		this.posecenaPozorista = new ArrayList<Pozoriste>();
		//this.listaObicnihRezervacija = new ArrayList<ObicnaRezervacija>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public boolean isAktiviranNalogPrekoMejla() {
		return aktiviranNalogPrekoMejla;
	}

	public void setAktiviranNalogPrekoMejla(boolean aktiviranNalogPrekoMejla) {
		this.aktiviranNalogPrekoMejla = aktiviranNalogPrekoMejla;
	}

	public boolean isPrviPutSeUlogovao() {
		return prviPutSeUlogovao;
	}

	public void setPrviPutSeUlogovao(boolean prviPutSeUlogovao) {
		this.prviPutSeUlogovao = prviPutSeUlogovao;
	}
	
	public int getBrojPoseta() {
		return brojPoseta;
	}

	public void setBrojPoseta(int brojPoseta) {
		this.brojPoseta = brojPoseta;
	}
	
	public String getVrstaClana() {
		return vrstaClana;
	}

	public void setVrstaClana(String vrstaClana) {
		this.vrstaClana = vrstaClana;
	}
	
	public List<Korisnik> getMojiPrijatelji() {
		return mojiPrijatelji;
	}

	public void setMojiPrijatelji(List<Korisnik> mojiPrijatelji) {
		this.mojiPrijatelji = mojiPrijatelji;
	}
	
	public List<Korisnik> getKomeSamJaPrijatelj() {
		return komeSamJaPrijatelj;
	}

	public void setKomeSamJaPrijatelj(List<Korisnik> komeSamJaPrijatelj) {
		this.komeSamJaPrijatelj = komeSamJaPrijatelj;
	}
	
	public List<Korisnik> getZahteviZaPrijateljstvo() {
		return zahteviZaPrijateljstvo;
	}

	public void setZahteviZaPrijateljstvo(List<Korisnik> zahteviZaPrijateljstvo) {
		this.zahteviZaPrijateljstvo = zahteviZaPrijateljstvo;
	}
	
	public List<Bioskop> getPoseceniBioskopi() {
		return poseceniBioskopi;
	}

	public void setPoseceniBioskopi(List<Bioskop> poseceniBioskopi) {
		this.poseceniBioskopi = poseceniBioskopi;
	}
	
	public List<Pozoriste> getPosecenaPozorista() {
		return posecenaPozorista;
	}

	public void setPosecenaPozorista(List<Pozoriste> posecenaPozorista) {
		this.posecenaPozorista = posecenaPozorista;
	}

	public FanZona getFanZonaAdmin() {
		return fanZonaAdmin;
	}

	public void setFanZonaAdmin(FanZona fanZonaAdmin) {
		this.fanZonaAdmin = fanZonaAdmin;
	}
	
	/*public List<ObicnaRezervacija> getListaObicnihRezervacija() {
		return listaObicnihRezervacija;
	}

	public void setListaObicnihRezervacija(List<ObicnaRezervacija> listaObicnihRezervacija) {
		this.listaObicnihRezervacija = listaObicnihRezervacija;
	}*/
	
	
	
}

