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
	
	/*
	 * Anotacija za oznacavanje asinhronog zadatka
	 */
	@Async
	public void sendMail(Korisnik korisnik) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacija korisnickog naloga");
		mail.setText("Da biste aktivirali Vas korisnicki nalog, molimo posetite sledeci link:\n http://localhost:8080/korisnik/aktivirajKorisnickiNalog/"+korisnik.getEmail());
		javaMailSender.send(mail);
    }
	
	
	/*
	 * Anotacija za oznacavanje asinhronog zadatka
	 */
	@Async
	public void sendMailReservation(Korisnik korisnik, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("nijemidosadno@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Podaci o napravljenoj rezervaciji");
		mail.setText(poruka + "\n\n\nZa povratak u aplikaciju posetite sledeci link: http://localhost:8080/index.html");
		javaMailSender.send(mail);
    }
}
