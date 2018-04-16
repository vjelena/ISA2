insert into adresa values (11, '67', 'Novi Sad', 'Dositejeva');
insert into korisnik values(1, 1, '123456', 'petar@gmail.com' , 'Petar', '111', 'Petrovic', 0, 'obican', 11);

insert into adresa values (12, '35', 'Beograd', 'Puskinova');
insert into korisnik values(2, 1, '095346', 'admin@gmail.com' , 'Marko', '222', 'Markovic', 0, 'sistem', 12);

insert into adresa values (13, '49', 'Nis', 'Fruskogorska');
insert into korisnik values(3, 1, '459245', 'nikola@gmail.com' , 'Nikola', '333', 'Nikolic', 0, 'obican', 13);

insert into adresa values (14, '147', 'Subotica', 'Kralja Aleksandra');
insert into korisnik values(4, 1, '294850', 'milica@gmail.com' , 'Milica', '444', 'Milic', 0, 'obican', 14);

insert into adresa values (15, '2', 'Kraljevo', 'Podunavskog odreda');
insert into korisnik values(5, 1, '346964', 'fanzona@gmail.com' , 'Nevena', '555', 'Jovic', 0, 'fanzona', 15);

insert into adresa values (16, '68', 'Novi Sad', 'Cirpanova');
insert into korisnik values(6, 1, '346964', 'adminbioskopa@gmail.com' , 'Nena', '666', 'Vidovic', 0, 'bioskop', 16);


INSERT INTO adresa values (21,'Broj', 'grad', 'ulica');
INSERT INTO clan values (3, 10, 5, 'zlatni');


INSERT INTO adresa values (1, 'broj','Beograd', 'ulica');
INSERT INTO adresa values (2, '123','Novi Sad', 'Bulevar Osobodjenja');

INSERT INTO bioskop values (1, 'Arena Cineplex', 'Pored redovnog filmskog repertoara, u Areni Cineplex se organizuju svecane premijere domacih filmova, kao i festivali FEST, Cinema City, Cinemania i Kids Fest.', 3.5, 1 ,1);
INSERT INTO bioskop values (2, 'Cinestar ', 'Brend CineStar razvio se iz bioskopa kompanije Kieft Kieft Filmtheater GmbH, koja je, posle vise od cetiri decenije rada kao operater klasicnog bioskopa, još 1993. otvorila svoj prvi multipleks.', 4.0, 2,1);



INSERT INTO repertoar values (1,1);
INSERT INTO repertoar values (2,2);

INSERT INTO glumac values (1,'Alicia','Vikander');
INSERT INTO glumac values (2, 'Walton','Goggins');
INSERT INTO glumac values (3, 'Olivia','Cooke');


--INSERT INTO projekcija values (1, 120.90, 'Ready player one', 4.5, 'opis', 'Steven Spielberg', 'slika', 120, 'drama',1);
--INSERT INTO projekcija values (2, 150.00, 'Tomb raider 3D', 4.5 , 'Lara Kroft je strastvena, samostalna devojka i cerka ekscentricnog pustolova koji je nestao dok je ona jos bila tinejdzerka.', 'Roar Uthaug', 'slika', 120, 'drama',2);

INSERT INTO film values (1,'Ready player one', 4.5, 'opis', 'Steven Spielberg', 'slika', 120, 'drama');
INSERT INTO film values (2,'Tomb raider 3D', 4.5, 'Lara Kroft je strastvena, samostalna devojka i cerka ekscentricnog pustolova', 'Roar Uthaug', 'slika', 120, 'triler');

INSERT INTO sala values(1 ,150,1 ,'konfg',1);
INSERT INTO sala values(2 ,100 ,2 ,'konfg',2);

--INSERT INTO projekcija_sale values (1, 1);

--INSERT INTO bioskop_lista_sala values (1 , 1);
--INSERT INTO bioskop_lista_sala values (2 , 2);

--INSERT INTO glumac_projekcije values (1,1);
--INSERT INTO glumac_projekcije values (2,2);
--INSERT INTO glumac_projekcije values (3,2);

INSERT INTO projekcija_glumci values (1,1);
INSERT INTO projekcija_glumci values (2,2);
INSERT INTO projekcija_glumci values (3,2);

--INSERT INTO termin values (1, 120.0 , 1);

--INSERT INTO projekcija_termini values (1,1);

insert into fan_zona(naziv) values ('Fan zona'); --samo jedna fan zona postoji id = 1
insert into oglas(id, cena, datum, naziv, opis, slika, status, fan_zona_id) values (1, '100', '2018-11-10', 'Oglas 1', 'Opis oglasa 1', 'slika 1', 1, 1);
insert into oglas(id, cena, datum, naziv, opis, slika, status, fan_zona_id) values (2, '350', '2018-07-08', 'Oglas 2', 'Opis oglasa 2', 'slika 2', 1, 1);

insert into prodavnica(naziv) values ('Prodavnica');  --samo jedna prodavnica postoji id = 1
insert into rekvizit(id, naziv, opis, slika, cena, prodavnica_id) values (1, 'Rekvizit 1', 'Opis rekvizita 1', 'slika 1', '33', 1);
insert into rekvizit(id, naziv, opis, slika, cena, prodavnica_id) values (2, 'Rekvizit 2', 'Opis rekvizita 2', 'slika 2', '5', 1);
