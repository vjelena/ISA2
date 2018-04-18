insert into adresa(id, broj, grad, ulica) values (11, '67', 'Novi Sad', 'Dositejeva');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id) 
values(1, 1, 14, '123456', 'petar@gmail.com' , 'Petar', '111', 'Petrovic', 0, 'obican', 'nema pravo na popust', 11);

insert into adresa(id, broj, grad, ulica) values (12, '35', 'Beograd', 'Puskinova');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id) 
values(2, 1, 3, '095346', 'admin@gmail.com' , 'Marko', '222', 'Markovic', 0, 'sistem', 'zlatni', 12);

insert into adresa(id, broj, grad, ulica) values (13, '49', 'Nis', 'Fruskogorska');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id)
values(3, 1, 9, '459245', 'nikola@gmail.com' , 'Nikola', '333', 'Nikolic', 0, 'obican', 'srebrni', 13);

insert into adresa(id, broj, grad, ulica) values (14, '147', 'Subotica', 'Kralja Aleksandra');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id)
values(4, 1, 1, '294850', 'milica@gmail.com' , 'Milica', '444', 'Milic', 0, 'obican', 'bronzani', 14);

insert into adresa(id, broj, grad, ulica) values (15, '2', 'Kraljevo', 'Podunavskog odreda');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id)
values(5, 1, 25, '346964', 'fanzona@gmail.com' , 'Nevena', '555', 'Jovic', 0, 'fanzona', 'zlatni', 15);

insert into adresa(id, broj, grad, ulica) values (16, '68', 'Novi Sad', 'Cirpanova');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id)
values(6, 1, 16, '346964', 'adminbioskopa@gmail.com' , 'Nena', '666', 'Vidovic', 0, 'bioskop', 'zlatni', 16);

insert into adresa(id, broj, grad, ulica) values (17, '39', 'Novi Pazar', 'Masarikova');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id) 
values(7, 1, 5, '436499', 'jovan@gmail.com' , 'Jovan', '777', 'Jovanovic', 0, 'obican', 'bronzani', 17);

insert into adresa(id, broj, grad, ulica) values (18, '3', 'Sabac', 'Franje Stefanovica');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id) 
values(8, 1, 9, '3046853', 'mira@gmail.com' , 'Mira', '888', 'Mirkovic', 0, 'obican', 'srebrni', 18);

insert into adresa(id, broj, grad, ulica) values (19, '48', 'Valjevo', 'Vojvode Supljikca');
insert into korisnik(id, aktiviran_nalog_preko_mejla, broj_poseta, broj_telefona, email, ime, lozinka, prezime, prvi_put_se_ulogovao, uloga, vrsta_clana, adresa_id) 
values(9, 1, 19, '794758', 'stefan@gmail.com' , 'Stefan', '999', 'Stefanovic', 0, 'obican', 'nema pravo na popust', 19);

--Petar i Stefan nisu prijatelji -> radi sa njima
insert into moji_prijatelji values(1, 3);
insert into moji_prijatelji values(1, 4);
insert into moji_prijatelji values(1, 7);
insert into moji_prijatelji values(1, 8);

insert into moji_prijatelji values(3, 1);
insert into moji_prijatelji values(3, 4);
insert into moji_prijatelji values(3, 7);
insert into moji_prijatelji values(3, 8);
insert into moji_prijatelji values(3, 9);

insert into moji_prijatelji values(4, 1);
insert into moji_prijatelji values(4, 3);
insert into moji_prijatelji values(4, 7);
insert into moji_prijatelji values(4, 8);
insert into moji_prijatelji values(4, 9);

insert into moji_prijatelji values(7, 1);
insert into moji_prijatelji values(7, 3);
insert into moji_prijatelji values(7, 4);
insert into moji_prijatelji values(7, 8);
insert into moji_prijatelji values(7, 9);

insert into moji_prijatelji values(8, 1);
insert into moji_prijatelji values(8, 3);
insert into moji_prijatelji values(8, 4);
insert into moji_prijatelji values(8, 7);
insert into moji_prijatelji values(8, 9);

insert into moji_prijatelji values(9, 3);
insert into moji_prijatelji values(9, 4);
insert into moji_prijatelji values(9, 7);
insert into moji_prijatelji values(9, 8);


insert into fan_zona(naziv) values ('fan zona'); --samo jedna fan zona postoji id = 1


insert into bioskop values (1, 'Jadran', 'Na repertoaru bioskopa Jadra mozete pogledati brojne popularne klasike.', 3.5, '45.25' , '19.845' , 11, 1);
insert into bioskop values (2, 'Arena Cineplex', 'Pored redovnog filmskog repertoara, u Areni Cineplex se organizuju svecane premijere domacih filmova, kao i festivali FEST, Cinema City, Cinemania i Kids Fest.', 4.5,'35.10','56.30',12, 1);
insert into bioskop values (3, 'Cinestar', 'Brend CineStar razvio se iz bioskopa kompanije Kieft Kieft Filmtheater GmbH, koja je, posle vise od cetiri decenije rada kao operater klasicnog bioskopa, još 1993. otvorila svoj prvi multipleks.', 4.0,'37.20','20.25',13, 1);
insert into bioskop values (4, 'Bioskop 4', 'Opis bioskopa 4.', 4.3,'26.25','32.20', 15, 1);


insert into repertoar values (1, 1);
insert into repertoar values (2, 2);
insert into repertoar values (3, 3);
insert into repertoar values (4, 4);


INSERT INTO film values (1,'Ready player one', 4.2, 'opis', 'Steven Spielberg', 'slika 1', 120, 'drama');
INSERT INTO film values (2,'Tomb raider 3D', 4.5, 'Lara Kroft je strastvena, samostalna devojka i cerka ekscentricnog pustolova.', 'Roar Uthaug', 'slika 2', 120, 'triler');
insert into film values (3, 'Eat, pray, love', 5, 'Romanticna prica o pomalo izgubljenoj devojci.', 'reditelj 3', 'slika 3', 193, 'romanticna komedija');


insert into sala values(1, 150, 'konfiguracija A', 'sala A', 2);
insert into sala values(2, 100, 'konfiguracija B', 'sala B', 3);
insert into sala values(3, 100, 'konfiguracija B', 'sala C', 1);
insert into sala values(4, 100, 'konfiguracija B', 'sala D', 4);
insert into sala values(5, 100, 'konfiguracija B', 'sala E', 1);
insert into sala values(6, 100, 'konfiguracija B', 'sala F', 2);


insert into termin values (1, '2018-04-18T03:05');
insert into termin values (2, '2018-04-01T05:06');
insert into termin values (3, '2018-04-03T12:15');
insert into termin values (4, '2018-04-21T03:21');
insert into termin values (5, '2018-04-22T03:45');



insert into projekcija values (1, 420, 3, 1, 2, 5);
insert into projekcija values (2, 350, 1, 2, 1, 2);
insert into projekcija values (3, 420, 3, 3, 2, 3);
insert into projekcija values (4, 350, 2, 4, 1, 4);


insert into glumac values (1, 'Alicia', 'Vikander');
insert into glumac values (2, 'Walton', 'Goggins');
insert into glumac values (3, 'Olivia', 'Cooke');
insert into glumac values (4, 'Jack', 'Nicholson');
insert into glumac values (5, 'Al', 'Pacino');
insert into glumac values (6, 'Tom', 'Hanks');

insert into film_glumci values (1, 1);
insert into film_glumci values (1, 2);
insert into film_glumci values (2, 3);
insert into film_glumci values (2, 4);
insert into film_glumci values (2, 6);
insert into film_glumci values (3, 5);
insert into film_glumci values (3, 6);


insert into bioskop_lista_sala values (1, 1);
insert into bioskop_lista_sala values (2, 2);
insert into bioskop_lista_sala values (3, 3);
insert into bioskop_lista_sala values (4, 4);



insert into oglas(id, cena, datum, naziv, opis, slika, status, fan_zona_id) values (1, '100', '2018-11-10', 'Oglas 1', 'Opis oglasa 1', 'slika 1', 1, 1);
insert into oglas(id, cena, datum, naziv, opis, slika, status, fan_zona_id) values (2, '350', '2018-07-08', 'Oglas 2', 'Opis oglasa 2', 'slika 2', 1, 1);


insert into prodavnica(naziv) values ('prodavnica');  --samo jedna prodavnica postoji id = 1


insert into rekvizit(id, naziv, opis, slika, cena, prodavnica_id) values (1, 'Rekvizit 1', 'Opis rekvizita 1', 'slika 1', '33', 1);
insert into rekvizit(id, naziv, opis, slika, cena, prodavnica_id) values (2, 'Rekvizit 2', 'Opis rekvizita 2', 'slika 2', '5', 1);
