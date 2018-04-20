package com.ftn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.DTO.BioskopDTO;
import com.ftn.DTO.KorisnikAdminDTO;
import com.ftn.DTO.SkalaDTO;
import com.ftn.model.Adresa;
import com.ftn.model.Bioskop;
import com.ftn.model.FanZona;
import com.ftn.model.Korisnik;
import com.ftn.model.Skala;
import com.ftn.service.AdresaService;
import com.ftn.service.FanZonaServis;
import com.ftn.service.KorisnikService;
import com.ftn.service.impl.JpaBioskopService;
import com.ftn.service.impl.JpaSalaService;

@RestController
@RequestMapping(value = "/admin")
public class AdminSistemaKontroler {

	@Autowired
	private FanZonaServis fanZonaServis;
	
	@Autowired
	private JpaBioskopService jpaBioskopService;
	
	@Autowired
	private JpaSalaService jpaSalaService;
	
	@Autowired
	private KorisnikService korisnikServis;
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajBioskop", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bioskop> dodajBioskop(@RequestBody BioskopDTO bioskopDTO) {
		Bioskop noviBioskop = new Bioskop();
		//System.out.println("*****"+bioskopDTO.toString());
		Adresa adresa = new Adresa(bioskopDTO.getUlica(), bioskopDTO.getBroj(), bioskopDTO.getGrad());
		
		noviBioskop.setNaziv(bioskopDTO.getNaziv());
		noviBioskop.setOpis(bioskopDTO.getOpis());
		noviBioskop.setProsecnaOcena(0);
		noviBioskop.setFanZona(fanZonaServis.findOne((long) 1));
		noviBioskop.setAdresa(adresa);
		noviBioskop.setxKoordinata(bioskopDTO.getxKoordinata());
		noviBioskop.setyKoordinata(bioskopDTO.getyKoordianta());
		Skala skala = new Skala(0,0,0,0,0,0);
		noviBioskop.setSkala(skala);
		System.out.println("*******");
		Adresa a = new Adresa(" ", " ", " ");
		Korisnik admin = new Korisnik(" ", " ", " ", " ", a, " ", " ",false, false, " ");
		korisnikServis.save(admin);
		System.out.println("aaaaaaaaaaaaaaaaaaaa");
		noviBioskop.setAdmin(admin);
		
		jpaBioskopService.save(noviBioskop);		
		return new ResponseEntity<>(noviBioskop, HttpStatus.OK);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/dodajSalu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sala> dodajSalu(@RequestBody SalaDTO salaDTO) {
		System.out.println(salaDTO.toString());
		System.out.println(jpaBioskopService.nadjiJedanBioskop("1").toString());
		
		Bioskop b = jpaBioskopService.nadjiJedanBioskop(salaDTO.getBioskop());
		
		Sala novaSala = new Sala();
		novaSala.setBioskop(b);
		novaSala.setBrojMesta(salaDTO.getBrojMesta());
		novaSala.setNazivSale(salaDTO.getBrojSale());
		novaSala.setKonfiguracija(salaDTO.getKonfiguracija());
		b.getListaSala().add(novaSala);
		
		System.out.println("BROJ DODATIH SALA JE: "  + jpaBioskopService.nadjiJedanBioskop("1").getListaSala().size());
		jpaSalaService.save(novaSala);
		jpaBioskopService.save(b);
		return new ResponseEntity<>(novaSala, HttpStatus.OK);
	}*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajSkalu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Skala> dodajSkalu(@RequestBody SkalaDTO skalaDTO) {
		System.out.println(skalaDTO.toString());
		System.out.println(skalaDTO.getSrebrni());
		
		Bioskop b = jpaBioskopService.nadjiJedanBioskop(skalaDTO.getBioskop());
		
		Skala novaSkala = b.getSkala();
		novaSkala.setZlatni(skalaDTO.getZlatni());
		novaSkala.setSrebrni(skalaDTO.getSrebrni());
		novaSkala.setBronzani(skalaDTO.getBronzani());
		novaSkala.setZlatniPopust(skalaDTO.getZlatniPopust());
		novaSkala.setSrebrniPopust(skalaDTO.getSrebrniPopust());
		novaSkala.setBronzaniPopust(skalaDTO.getBronzaniPopust());		
		System.out.println("NOVA SKALA SREBRNI: " + novaSkala.getSrebrni());	
		b.setSkala(novaSkala);
		System.out.println("BROJ DODATIH SALA JE: "  + jpaBioskopService.nadjiJedanBioskop("1").getListaSala().size());
		jpaBioskopService.save(b);
		return new ResponseEntity<>(novaSkala, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajAdmina", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> dodajAdmina(@RequestBody KorisnikAdminDTO korisnikDTO) {
		System.out.println(korisnikDTO.toString());
		Adresa adresa = new Adresa(korisnikDTO.getUlica(), korisnikDTO.getBroj(), korisnikDTO.getGrad());
		Korisnik k = new Korisnik(korisnikDTO.getEmail(), korisnikDTO.getLozinka(), korisnikDTO.getIme(),
				korisnikDTO.getPrezime(), adresa, korisnikDTO.getBrojTelefona(), korisnikDTO.getUloga(), true, false, "zlatni");
		List<Korisnik> lista = korisnikServis.findAll();
		
		for(int i = 0; i < lista.size(); i++) {
			Korisnik kor = lista.get(i);
			if(!kor.getEmail().equals(k.getEmail())) {
				if(!k.getEmail().isEmpty() && !k.getLozinka().isEmpty() && !k.getIme().isEmpty() && !k.getPrezime().isEmpty() && !k.getAdresa().getUlica().toString().isEmpty() && !k.getAdresa().getBroj().toString().isEmpty() && !k.getAdresa().getGrad().toString().isEmpty() && !k.getBrojTelefona().isEmpty()) {
					if(k.getUloga().equals("fanzona")){
						System.out.println("Usao u if za admina fan zone");
						FanZona fanzona = fanZonaServis.findOne((long)1);
						fanzona.getAdmini().add(k);
						fanZonaServis.save(fanzona);
						k.setFanZonaAdmin(fanzona);
						korisnikServis.save(k);
					}else if(k.getUloga().equals("bioskop")){
						System.out.println("Usao u if za admina bioskopa");
						Bioskop b = jpaBioskopService.nadjiJedanBioskop(korisnikDTO.getBioskop());
						Korisnik admin = b.getAdmin();
						Adresa a = admin.getAdresa();
						a.setBroj(korisnikDTO.getBroj());
						a.setGrad(korisnikDTO.getGrad());
						a.setUlica(korisnikDTO.getUlica());
						admin.setEmail(korisnikDTO.getEmail());
						admin.setLozinka(korisnikDTO.getLozinka());
						admin.setIme(korisnikDTO.getIme());
						admin.setPrezime(korisnikDTO.getPrezime());
						admin.setBrojPoseta(0);
						admin.setAktiviranNalogPrekoMejla(true);
						admin.setBrojTelefona(korisnikDTO.getBrojTelefona());
						admin.setPrviPutSeUlogovao(false);
						admin.setUloga(korisnikDTO.getUloga());
						admin.setVrstaClana("zlatni");
						admin.setAdresa(a);
						b.setAdmin(admin);
						jpaBioskopService.save(b);
					}
					return new ResponseEntity<Korisnik>(k, HttpStatus.OK);
				}
			}else{
				System.out.println("ISTI EMAIL");
			}
		}
		
		return new ResponseEntity<Korisnik>(k, HttpStatus.BAD_REQUEST);
	}
}
