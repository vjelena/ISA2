package com.ftn.DTOconverter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ftn.DTO.FilmDTO;
import com.ftn.DTO.SalaDTO;
import com.ftn.model.Bioskop;
import com.ftn.model.Film;
import com.ftn.model.Sala;
import com.ftn.service.BioskopService;
import com.ftn.service.impl.JpaFilmService;
import com.ftn.service.impl.JpaSalaService;

public class FilmDTOtoFilm {


	@Autowired
	private JpaFilmService jpaFilmService ;
	
	
	public Film convert(FilmDTO source) {
		
		if(source == null) {
			return null;
		}
		
		
		Film film = new Film();
		film.setNaziv(source.getNaziv());
		film.setOpis(source.getOpis());
		film.setReditelj(source.getReditelj());
		film.setZanr(source.getZanr());
		film.setTrajanje(source.getTrajanje());
		film.setOcena(source.getOcena());
		film.setSlika(source.getSlika());
		//film.setGlumci(source.getGlumacId());
		
		return film;
	}
	
	
public List<Film> convert(List<FilmDTO> source){
		
		List<Film> film = new ArrayList<Film>();
		for (FilmDTO filmDTO : source) {
			film.add(convert(filmDTO));
		}
		return film;
	}
	
}
