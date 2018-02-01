package com.ftn.model;

import java.sql.Date;

public class Oglas {

	private Korisnik korisnik;
	private String naziv;
	private String opis;
	private Date datum; //do kada je aktivno prikupljanje ponuda
	private String slika;
	private boolean odobren;
}
