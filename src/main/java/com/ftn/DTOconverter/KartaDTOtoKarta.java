package com.ftn.DTOconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.ftn.DTO.KartaDTO;
import com.ftn.model.Karta;
import com.ftn.model.Projekcija;
import com.ftn.model.Sediste;
import com.ftn.service.impl.JpaGlumacService;
import com.ftn.service.impl.JpaProjekcijaService;
import com.ftn.service.impl.JpaSedisteService;

@Component
public class KartaDTOtoKarta {
	
	@Autowired
	private JpaProjekcijaService jpaProjekcijaService ;
	
	@Autowired
	private JpaSedisteService jpaSedisteService ;
	
	
	@Autowired
	private JpaGlumacService jpaGlumacService ;
	
	
	public Karta convert(KartaDTO source) {
		
		if(source == null) {
			return null;
		}
		
		Projekcija projekcija = jpaProjekcijaService.nadjiJednuProjekciju(source.getIdProjekcije());
		
		Sediste sediste = new Sediste();
		sediste.setRbr(new Integer(source.getSjedisteId()));
		sediste.setSala(projekcija.getSala());
		
		
		Karta karta = new Karta();
		karta.setProjekcija(projekcija);
		karta.setKartaSPopustom(true);
		karta.setKupljena(false);
		karta.setSediste(sediste);
		karta.setPopust(new Float(source.getPopust()));
		
		return karta;
	}
	
	
	

}
