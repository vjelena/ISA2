package com.ftn.model;

import java.util.Set;

public class Korisnik {

	private String ime;
	private String prezime;
	private String email;
	private String lozinka;
	private String brojTelefona;
	private Adresa adresa;
	private Grad grad;
	private String uloga;
	private float ocenaAmbijenta;
	private float ocenaProjekcije;
	private Set<ZahtevZaPrijateljstvo> listaZahtevaZaPrijateljstvo;
	private Set<Rezervacija> listaRezervacija;
	private Set<Rekvizit> listaRekvizita;
	private Set<Oglas> listaOglasa;
	private Clan clan;
}

