package com.ftn.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.model.Korisnik;
import com.ftn.repository.KorisnikRepository;
import com.ftn.service.EmailService;

@RestController
@RequestMapping(value = "/podaciORezervacijiBezPrijatelja")
public class PodaciORezervacijiBezPrijateljaController {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private EmailService emailService;
	
	
	//BIOSKOP:
	//slanje mejla o detaljima rezervacije
	@RequestMapping(value = "/podaciORezervacijiZaSlanjeMejla/{nazivSelektovanogBioskopa}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovaneSale}/{selektovanaSedista}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> podaciORezervacijiZaSlanjeMejla(@PathVariable String nazivSelektovanogBioskopa, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovaneSale, @PathVariable String selektovanaSedista, HttpServletRequest request) throws MailException, InterruptedException, MessagingException {						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJeNapravioRezervaciju = korisnikRepository.findById(k.getId());
		
		String poruka = "Vasa rezervacija:\n" 
						+ "\tbioskop: " + nazivSelektovanogBioskopa + "\n" 
						+ "\tprojekcija: " + nazivSelektovaneProjekcije + "\n"
						+ "\ttermin: " + nazivSelektovanogTermina + "\n"
						+ "\tsala: " + nazivSelektovaneSale + "\n"
						+ "\tsediste: " + selektovanaSedista;
		
		emailService.sendMailReservationWithoutFriends(koJeNapravioRezervaciju, poruka);			
		return new ResponseEntity<>(koJeNapravioRezervaciju, HttpStatus.OK);
	}
	
	//POZORISTE:
	//slanje mejla o detaljima rezervacije
	@RequestMapping(value = "/podaciORezervacijiZaSlanjeMejlaPozoriste/{nazivSelektovanogPozorista}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovaneSale}/{selektovanaSedista}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> podaciORezervacijiZaSlanjeMejlaPozoriste(@PathVariable String nazivSelektovanogPozorista, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovaneSale, @PathVariable String selektovanaSedista, HttpServletRequest request) throws MailException, InterruptedException, MessagingException {						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJeNapravioRezervaciju = korisnikRepository.findById(k.getId());
			
		String poruka = "Vasa rezervacija:\n" 
						+ "\tpozoriste: " + nazivSelektovanogPozorista + "\n" 
						+ "\tprojekcija: " + nazivSelektovaneProjekcije + "\n"
						+ "\ttermin: " + nazivSelektovanogTermina + "\n"
						+ "\tsala: " + nazivSelektovaneSale + "\n"
						+ "\tsediste: " + selektovanaSedista;
			
		emailService.sendMailReservationPozoristeWithoutFriends(koJeNapravioRezervaciju, poruka);			
		return new ResponseEntity<>(koJeNapravioRezervaciju, HttpStatus.OK);
	}
	
}
