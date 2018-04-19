package com.ftn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ftn.model.Korisnik;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	//aktivacija korisnickog naloga
	@Async
	public void sendMail(Korisnik korisnik) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacija korisnickog naloga");
		mail.setText("Da biste aktivirali Vas korisnicki nalog, molimo posetite sledeci link: http://localhost:8080/korisnik/aktivirajKorisnickiNalog/"+korisnik.getEmail());
		javaMailSender.send(mail);
    }
	
	
	//BIOSKOP (SA PRIJATELJIMA):
	@Async
	public void sendMailReservation(Korisnik korisnik, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[BIOSKOP, sa prijateljima] Podaci o napravljenoj rezervaciji");
		mail.setText(poruka + "\n\n\nZa povratak u aplikaciju posetite sledeci link: http://localhost:8080/index.html");
		javaMailSender.send(mail);
    }
		
	@Async
	public void sendMailReservationFriend(Korisnik korisnik, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[BIOSKOP, sa prijateljima] Poziv na projekciju filma");
		mail.setText(poruka + "\nZa potvrdu/odustanak od dolaska na projekciju, poseti sledeci link: http://localhost:8080/potvrdaOdustanakOdDolaskaNaProjekciju.html" + "\n\n\nPovratak u aplikaciju: http://localhost:8080/index.html");
		javaMailSender.send(mail);
    }
	
	
	//POZORISTE (SA PRIJATELJIMA):
	@Async
	public void sendMailReservationPozoriste(Korisnik korisnik, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[POZORISTE, sa prijateljima] Podaci o napravljenoj rezervaciji");
		mail.setText(poruka + "\n\n\nZa povratak u aplikaciju posetite sledeci link: http://localhost:8080/index.html");
		javaMailSender.send(mail);
    }
		
	@Async
	public void sendMailReservationFriendPozoriste(Korisnik korisnik, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[POZORISTE, sa prijateljima] Poziv na projekciju predstave");
		mail.setText(poruka + "\nZa potvrdu/odustanak od dolaska na projekciju, poseti sledeci link: http://localhost:8080/potvrdaOdustanakOdDolaskaNaProjekciju.html" + "\n\n\nPovratak u aplikaciju: http://localhost:8080/index.html");
		javaMailSender.send(mail);
    }
	
	
	//BIOSKOP (BEZ PRIJATELJA):
	@Async
	public void sendMailReservationWithoutFriends(Korisnik korisnik, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[BIOSKOP, bez prijatelja] Podaci o napravljenoj rezervaciji");
		mail.setText(poruka + "\n\n\nZa povratak u aplikaciju posetite sledeci link: http://localhost:8080/index.html");
		javaMailSender.send(mail);
    }
	
	//POZORISTE (BEZ PRIJATELJA):
	@Async
	public void sendMailReservationPozoristeWithoutFriends(Korisnik korisnik, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("[POZORISTE, bez prijatelja] Podaci o napravljenoj rezervaciji");
		mail.setText(poruka + "\n\n\nZa povratak u aplikaciju posetite sledeci link: http://localhost:8080/index.html");
		javaMailSender.send(mail);
	}
	
}
