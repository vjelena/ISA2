package com.ftn.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.ftn.model.Glumac;

@Service
public interface GlumacService {
	
public List<Glumac> nadjiSveGlumce();
	
	
	public Glumac kreirajGlumca(Glumac glumac);


	public Glumac nadjiJednogGlumca(String id);

}
