package com.ftn.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ftn.model.Pozoriste;


@Service
public interface PozoristeService {
	
	public List<Pozoriste> nadjiSvaPozorista();
	
	public Pozoriste kreirajPozoriste(Pozoriste pozoriste);

	public Pozoriste nadjiJednoPozoriste(String id);
	
	public Pozoriste save(Pozoriste pozoriste);

}
