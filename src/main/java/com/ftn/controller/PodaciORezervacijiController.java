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
@RequestMapping(value = "/podaciORezervaciji")
public class PodaciORezervacijiController {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private EmailService emailService;
	
	
	//BIOSKOP:
	//slanje mejla o detaljima rezervacije
	@RequestMapping(value = "/podaciORezervacijiZaSlanjeMejla/{nazivSelektovanogBioskopa}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovaneSale}/{nazivSelektovanogPrijatelja}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> podaciORezervacijiZaSlanjeMejla(@PathVariable String nazivSelektovanogBioskopa, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovaneSale, @PathVariable String nazivSelektovanogPrijatelja, HttpServletRequest request) throws MailException, InterruptedException, MessagingException {						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJeNapravioRezervaciju = korisnikRepository.findById(k.getId());
		
		String poruka = "Vasa rezervacija:\n" 
						+ "\tbioskop: " + nazivSelektovanogBioskopa + "\n" 
						+ "\tprojekcija: " + nazivSelektovaneProjekcije + "\n"
						+ "\ttermin: " + nazivSelektovanogTermina + "\n"
						+ "\tsala: " + nazivSelektovaneSale + "\n"
						+ "\tpozvan prijatelj: " + nazivSelektovanogPrijatelja;
		
		emailService.sendMailReservation(koJeNapravioRezervaciju, poruka);			
		return new ResponseEntity<>(koJeNapravioRezervaciju, HttpStatus.OK);
	}
	
	//slanje mejla pozvanom prijatelju
	@RequestMapping(value = "/rezervacijaPozvanPrijatelj/{email}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovanogBioskopa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> rezervacijaPozvanPrijatelj(@PathVariable String email, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovanogBioskopa, HttpServletRequest request) throws MailException, InterruptedException, MessagingException {						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJeNapravioRezervaciju = korisnikRepository.findById(k.getId());
		
		String poruka = "Pozivam te da mi se pridruzis na projekciji filma '" + nazivSelektovaneProjekcije + "', u terminu " + nazivSelektovanogTermina + " , u bioskopu '" + nazivSelektovanogBioskopa + "'" + ".";
		
		emailService.sendMailReservationFriend(koJeNapravioRezervaciju, poruka);		
		return new ResponseEntity<>(koJeNapravioRezervaciju, HttpStatus.OK);
	}
	
	//POZORISTE:
	//slanje mejla o detaljima rezervacije
	@RequestMapping(value = "/podaciORezervacijiZaSlanjeMejlaPozoriste/{nazivSelektovanogPozorista}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovaneSale}/{nazivSelektovanogPrijatelja}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> podaciORezervacijiZaSlanjeMejlaPozoriste(@PathVariable String nazivSelektovanogPozorista, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovaneSale, @PathVariable String nazivSelektovanogPrijatelja, HttpServletRequest request) throws MailException, InterruptedException, MessagingException {						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJeNapravioRezervaciju = korisnikRepository.findById(k.getId());
			
		String poruka = "Vasa rezervacija:\n" 
						+ "\tpozoriste: " + nazivSelektovanogPozorista + "\n" 
						+ "\tprojekcija: " + nazivSelektovaneProjekcije + "\n"
						+ "\ttermin: " + nazivSelektovanogTermina + "\n"
						+ "\tsala: " + nazivSelektovaneSale + "\n"
						+ "\tpozvan prijatelj: " + nazivSelektovanogPrijatelja;
			
		emailService.sendMailReservationPozoriste(koJeNapravioRezervaciju, poruka);			
		return new ResponseEntity<>(koJeNapravioRezervaciju, HttpStatus.OK);
	}
		
	//slanje mejla pozvanom prijatelju
	@RequestMapping(value = "/rezervacijaPozvanPrijateljPozoriste/{email}/{nazivSelektovaneProjekcije}/{nazivSelektovanogTermina}/{nazivSelektovanogPozorista}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Korisnik> rezervacijaPozvanPrijateljPozoriste(@PathVariable String email, @PathVariable String nazivSelektovaneProjekcije, @PathVariable String nazivSelektovanogTermina, @PathVariable String nazivSelektovanogPozorista, HttpServletRequest request) throws MailException, InterruptedException, MessagingException {						
		Korisnik k = (Korisnik) request.getSession().getAttribute("aktivanKorisnik");
		Korisnik koJeNapravioRezervaciju = korisnikRepository.findById(k.getId());
			
		String poruka = "Pozivam te da mi se pridruzis na projekciji predstave '" + nazivSelektovaneProjekcije + "', u terminu " + nazivSelektovanogTermina + ", u pozoristu '" + nazivSelektovanogPozorista + "'" + ".";
			
		emailService.sendMailReservationFriendPozoriste(koJeNapravioRezervaciju, poruka);		
		return new ResponseEntity<>(koJeNapravioRezervaciju, HttpStatus.OK);
	}
	
}
