package com.ftn.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Karta {

	@JsonBackReference //da se izbegne rekurzija prilikom snimanja u bazu
	private Bioskop bioskop;
	private Projekcija projekcija;
	private Date datum;
	private Sala sala;
	private Termin termin;
	private boolean prodata;
}
