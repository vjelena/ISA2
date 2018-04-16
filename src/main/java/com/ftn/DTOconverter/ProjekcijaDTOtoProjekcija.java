package com.ftn.DTOconverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.ftn.DTO.ProjekcijaDTO;
import com.ftn.model.Bioskop;
import com.ftn.model.FanZona;
import com.ftn.model.Oglas;
import com.ftn.model.Projekcija;
import com.ftn.service.BioskopService;
import com.ftn.service.FanZonaServis;

@Component
public class ProjekcijaDTOtoProjekcija implements Converter<ProjekcijaDTO, Projekcija>{

	@Autowired
	private BioskopService bioskopService;
	
	@Override
	public Projekcija convert(ProjekcijaDTO source) {
		
		if(source == null) {
			return null;
		}
		
		Bioskop bioskop = bioskopService.nadjiJedanBioskop(source.getBioskopId());
		
		
		Projekcija projekcija = new Projekcija();
		
		projekcija.setCena(source.getCena());
		projekcija.setNaziv(source.getNaziv());
		projekcija.setOcena(source.getOcena());
		projekcija.setOpis(source.getOpis());
		projekcija.setReditelj(source.getReditelj());
		projekcija.setRepertoar(bioskop.getRepertoar());
		projekcija.setSlika(source.getSlika());
		projekcija.setTrajanje(source.getTrajanje());
		projekcija.setZanr(source.getZanr());
		
		return projekcija;
	}
	
	
	public List<Projekcija> convert(List<ProjekcijaDTO> source){
		
		List<Projekcija> projekcije = new ArrayList<Projekcija>();
		for (ProjekcijaDTO projekcijaDTO : source) {
			projekcije.add(convert(projekcijaDTO));
		}
		
		return projekcije;
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
