package com.ftn.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Karta {

	@JsonBackReference //da se izbegne rekurzija prilikom snimanja u bazu
	private Bioskop bioskop;
	private Projekcija projekcija;
	private Date datum;
	// nije potrebno private float cena;
	private Sala sala;
	private Mesto mesto;
	private Termin termin;
}
