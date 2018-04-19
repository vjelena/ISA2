package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.ftn.model.IzvestajOPoslovanju;

@Service
public interface IzvjestajService {
	
	public List<IzvestajOPoslovanju> nadjiSveIzvjestaje();
	
	
	public IzvestajOPoslovanju kreirajIzvjestaj(IzvestajOPoslovanju izvjestaj);


	public IzvestajOPoslovanju nadjiJedanIzvjestaj(String id);
	
	
}
