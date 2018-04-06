
INSERT INTO grad values (1, 'Novi Sad');
INSERT INTO grad values (2, 'Beograd');

INSERT INTO adresa values (1, 68,'Kralja Petra', 1);
INSERT INTO adresa values (2, 123,'Bulevar Osobodjenja', 2);

INSERT INTO bioskop values (1, 'Arena Cineplex', 'Pored redovnog filmskog repertoara, u Areni Cineplex se organizuju svecane premijere domacih filmova, kao i festivali FEST, Cinema City, Cinemania i Kids Fest.', 3.5, 1 ,1);
INSERT INTO bioskop values (2, 'Cinestar ', 'Brend CineStar razvio se iz bioskopa kompanije Kieft Kieft Filmtheater GmbH, koja je, posle vise od cetiri decenije rada kao operater klasicnog bioskopa, još 1993. otvorila svoj prvi multipleks.', 4.0, 2,2);

insert into fan_zona values (1,1);
insert into fan_zona values (2,2);

insert into fan_zona values (3,'jaslkjfa');
insert into oglas(cena, datum, naziv, slika, opis, fan_zona_id, odobren) values('3', '11.11.2011.', 'naaziiv', 'slika','opis', 1, false)

--test drugog fajla