package com.ftn.model;

import java.util.Set;

public class Rezervacija {

	private Korisnik korisnik;
	private Bioskop bioskop;
	private Projekcija projekcija;
	private Set<Karta> listaKarta;
	private Set<Mesto> listaMesta;	//jquerry za graficki prikaz
	private Set<ZahtevZaPrijateljstvo> pozvaniPrijatelji;
}
