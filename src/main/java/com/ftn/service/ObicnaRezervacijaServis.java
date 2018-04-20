package com.ftn.service;

import java.util.List;

import com.ftn.model.ObicnaRezervacija;

public interface ObicnaRezervacijaServis {

	List<ObicnaRezervacija> findAll();
	
	ObicnaRezervacija save(ObicnaRezervacija obicnaRezervacija);
	
}
