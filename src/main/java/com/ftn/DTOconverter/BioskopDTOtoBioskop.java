package com.ftn.DTOconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.ftn.DTO.BioskopDTO;
import com.ftn.DTO.ProjekcijaDTO;
import com.ftn.model.Bioskop;
import com.ftn.model.Projekcija;
import com.ftn.service.BioskopService;

@Component
public class BioskopDTOtoBioskop implements Converter<BioskopDTO, Bioskop>{
	
	
	
	@Autowired
	private BioskopService bioskopService;
	

	@Override
	public Bioskop convert(BioskopDTO source) {

		if(source == null) {
			return null;
		}
		
		Bioskop bioskop = new Bioskop();
		bioskop.setNaziv(source.getNaziv());
		bioskop.setOpis(source.getOpis());
		bioskop.setxKoordinata(source.getxKoordinata());
		bioskop.setyKoordinata(source.getyKoordianta());
		
		return bioskop;
	}

	@Override
	public JavaType getInputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
