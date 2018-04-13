insert into adresa values (11, '67', 'Novi Sad', 'Dositejeva');
insert into korisnik values(1, 1, '123456', 'petar@gmail.com' , 'Petar', '123', 'Petrovic', 0, 'obican', 11);

insert into adresa values (12, '35', 'Beograd', 'Puskinova');
insert into korisnik values(2, 1, '095346', 'marko@gmail.com' , 'Marko', '777', 'Markovic', 0, 'admin', 12);


INSERT INTO adresa values (21,'Broj', 'grad', 'ulica');
INSERT INTO clan values (3, 10, 5, 'zlatni');


INSERT INTO adresa values (1, 'broj','Beograd', 'ulica');
INSERT INTO adresa values (2, '123','Novi Sad', 'Bulevar Osobodjenja');

INSERT INTO bioskop values (1, 'Arena Cineplex', 'Pored redovnog filmskog repertoara, u Areni Cineplex se organizuju svecane premijere domacih filmova, kao i festivali FEST, Cinema City, Cinemania i Kids Fest.', 3.5, 1 ,1);
INSERT INTO bioskop values (2, 'Cinestar ', 'Brend CineStar razvio se iz bioskopa kompanije Kieft Kieft Filmtheater GmbH, koja je, posle vise od cetiri decenije rada kao operater klasicnog bioskopa, još 1993. otvorila svoj prvi multipleks.', 4.0, 2,2);



INSERT INTO repertoar values (1,1);
INSERT INTO repertoar values (2,2);

INSERT INTO glumac values (1,'Alicia','Vikander');
INSERT INTO glumac values (2, 'Walton','Goggins');
INSERT INTO glumac values (3, 'Olivia','Cooke');


INSERT INTO projekcija values (1, 120.90, 'Ready player one', 4.5, 'opis', 'Steven Spielberg', 'slika', 120, 'drama',1);
INSERT INTO projekcija values (2, 150.00, 'Tomb raider 3D', 4.5 , 'Lara Kroft je strastvena, samostalna devojka i cerka ekscentricnog pustolova koji je nestao dok je ona jos bila tinejdzerka.', 'Roar Uthaug', 'slika', 120, 'drama',2);

INSERT INTO sala values(1 ,150,1 ,'konfg',1 ,1 );
INSERT INTO sala values(2 ,100 ,2 ,'konfg',2 ,2 );

INSERT INTO projekcija_sale values (1, 1);

INSERT INTO bioskop_lista_sala values (1 , 1);
INSERT INTO bioskop_lista_sala values (2 , 2);

INSERT INTO glumac_projekcije values (1,1);
INSERT INTO glumac_projekcije values (2,2);
INSERT INTO glumac_projekcije values (3,2);

INSERT INTO projekcija_glumci values (1,1);
INSERT INTO projekcija_glumci values (2,2);
INSERT INTO projekcija_glumci values (3,2);

INSERT INTO termin values (1, 120.0 , 1);

insert into fan_zona(naziv) values ('jaslkjfa');
insert into fan_zona(naziv) values ('stgtrgtrdgrt');
