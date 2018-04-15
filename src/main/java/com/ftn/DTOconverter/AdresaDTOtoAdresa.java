package com.ftn.DTOconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.ftn.DTO.AdresaDTO;
import com.ftn.model.Adresa;
import com.ftn.model.FanZona;
import com.ftn.model.Oglas;
import com.ftn.service.KorisnikService;


@Component
public class AdresaDTOtoAdresa implements Converter<AdresaDTO, Adresa>{

	
	@Autowired
	private KorisnikService korisnikServis;
	
	@Override
	public Adresa convert(AdresaDTO source) {
		
		if(source == null) {
			return null;
		}
		
		Adresa adresa = new Adresa();
		
		adresa.setId(source.getId());
		adresa.setBroj(source.getBroj());
		adresa.setUlica(source.getUlica());
		adresa.setGrad(source.getGrad());
		
		return adresa;
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
