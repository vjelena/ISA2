package com.ftn.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	/*
	 * Anotacija za oznacavanje asinhronog zadatka
	 * Vise informacija na: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
	 */
	@Async
	public void sendMail(String emailAdresa, String naslov, String poruka) throws MailException, InterruptedException  {		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailAdresa);
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacija korisnickog naloga");
		mail.setText("Vas korisnicki nalog ce biti aktiviran." + poruka);
		javaMailSender.send(mail);
    }
	
}
