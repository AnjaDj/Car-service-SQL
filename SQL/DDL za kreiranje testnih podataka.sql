use auto_servis;

insert into mesto values (78000,'Banja Luka','Banja Luka','BiH');
insert into mesto values (78255,'Kotor Varos','Banja Luka','BiH');
insert into mesto values (89101,'Trebinje','Trebinje','BiH');

insert into stranka (PTTbroj, adresa) values (78000,'Branka Copica 4');
insert into stranka (PTTbroj, adresa) values (78000,'Milosa Obilica 14');
insert into stranka (PTTbroj, adresa) values (78255,'Carice Milice 28');
insert into stranka (PTTbroj, adresa) values (78255,'Dositeja Obradovica 3');
insert into stranka (PTTbroj, adresa) values (89101,'Cara Dusana 13');
insert into stranka (PTTbroj, adresa) values (89101,'Desanke Maksimovic 7');

insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F8K0B8D35K','M24-J-922','Volvo','S90','M',1);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7C690B8D35K','N24-A-922','Volvo','EX30','M',2);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F789B8D35K','G24-F-NJ9','Volvo','EX90','M',3);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F8TYG8D35K','H24-X-87L','Volvo','XC90','M',4);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A0CX3K7F8K0B8D35K','I24-O-924','Hyundai','i10','M',5);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F8K0BY755K','J24-I-952','Hyundai','i20','M',6);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F8K0B7835K','L24-U-912','Hyundai','i30','M',1);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F8K0B8D123','V24-Y-022','Hyundai','Elantra','M',2);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F8K0B8D456','O24-T-122','Honda','HRV','M',3);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A02KCK7F8K0B8D4FA','K24-R-222','Honda','Civic Sedan','M',4);
insert into vozilo (brojSasije,registracionaOznaka,marka,model,vrsta,idStranka) 
values ('A06KCK7F8K0B8D35T','W24-E-462','Honda','Odyssey','M',5);

insert into individua values('Duska','Milosevic',1);
insert into individua values('Nevena','Gligoric',2);
insert into individua values('Viktorija','Simic',3);
insert into preduzece values('Savo okovi d.o.o.',4);
insert into preduzece values('Petrovic s.p.',5);
insert into preduzece values('Jezerka s.p.',6);

insert into radna_stanica values (1,78000,'Vase Gligica 4');
insert into radna_stanica values (2,78255,'Perke Zloperke 12');
insert into radna_stanica values (3,89101,'Vladimira Gaca 14');

insert into zaposleni (ime,prezime,idRadnaStanica,radno_zvanje,PTTbroj,korisnickoIme,korisnickaLozinka) 
values ('Dusan','Gavric',1,'automehanicar',78000,'dusan','loza123');
insert into zaposleni (ime,prezime,idRadnaStanica,radno_zvanje,PTTbroj,korisnickoIme,korisnickaLozinka) 
values ('Milos','Vidic',1,'automehanicar',78000,'milos','loza123');
insert into zaposleni (ime,prezime,idRadnaStanica,radno_zvanje,PTTbroj,korisnickoIme,korisnickaLozinka) 
values ('Uros','Savic',1,'automehanicar',78000,'uros','loza123');
insert into zaposleni (ime,prezime,idRadnaStanica,radno_zvanje,PTTbroj,korisnickoIme,korisnickaLozinka) 
values ('Glorija','Durakovic',1,'autoelektricar',78000,'glorija','loza123');
insert into zaposleni (ime,prezime,idRadnaStanica,radno_zvanje,PTTbroj,korisnickoIme,korisnickaLozinka) 
values ('Elena','Stojjanovic',1,'autoelektricar',78000,'elena','loza123');
insert into zaposleni (ime,prezime,idRadnaStanica,radno_zvanje,PTTbroj,korisnickoIme,korisnickaLozinka) 
values ('Adrijana','Kurdic',1,'autolimar',78000,'adrijana','loza123');
insert into zaposleni (ime,prezime,idRadnaStanica,radno_zvanje,PTTbroj,korisnickoIme,korisnickaLozinka) 
values ('Natasa','Trifkovic',1,'autolimar',78000,'natasa','loza123');

insert into artikal values ('AMU101','MOTORNO ULJE ELF',14.90,100.00);
insert into artikal values ('AMU102','MOTORNO ULJE CASTROL',13.20,100.00);
insert into artikal values ('AK100','AKUMULATOR ATOM 45AH D+',60.25,23);
insert into artikal values ('AK101','Starter akumulator BOSCH',160.00,32);
insert into artikal values ('AK102','AKUMULATOR MOTO. 12V 5AH/70A D+ GEL',22.25,13);
insert into artikal values ('AOP100','K2 VZIGALNI KABLOVI',9.00,15);
insert into artikal values ('AOP101','K2 STRGALO ZA LED',5.00,156); 
insert into artikal values ('AOP102','K2 KOMPRESOR ZA PUNJENJE PNEUMATIKA', 120.00,13); 
insert into artikal values ('AOP103','SNEZNE VERIGE',35.00,300); 
insert into artikal values ('AM100','Filtar za ulje KNECHT OX 1076D',20.00,15); 
insert into artikal values ('AM101','FTR-OE650/8', 13.00,16); 
insert into artikal values ('AM102','DISK KOCNICA',53.00,24); 
insert into artikal values ('AM103','BUBANJ KOCNICA',53.00,18); 

insert into usluga values ('U100','Zamena motornog ulja',10.00); 
insert into usluga values ('U101','Balansiranje pneumatika',50.00); 
insert into usluga values ('U102','Zamena autostakala',100.00); 
insert into usluga values ('U103','Zamena akumulatora',20.00); 
insert into usluga values ('U104','Autolakirerske usluge po m2',50.00); 
insert into usluga values ('U105','Karoserijske popravke-lake po m2',50.00); 
insert into usluga values ('U106','Karoserijske popravke-teske po m2',100.00); 
insert into usluga values ('U107','Vulkanizacija',45.00); 
insert into usluga values ('U108','Zamena kocionog sistema',125.00); 

insert into vrsi values (1,'U100');
insert into vrsi values (1,'U101');
insert into vrsi values (1,'U102');
insert into vrsi values (1,'U103');
insert into vrsi values (1,'U104');
insert into vrsi values (1,'U105');
insert into vrsi values (1,'U106');
insert into vrsi values (1,'U107');
insert into vrsi values (1,'U108');

insert into prodaja values (1,'AMU101');
insert into prodaja values (1,'AMU102');
insert into prodaja values (1,'AK100');
insert into prodaja values (1,'AK101');
insert into prodaja values (1,'AK102');
insert into prodaja values (1,'AOP100');
insert into prodaja values (1,'AOP101');
insert into prodaja values (1,'AOP102');
insert into prodaja values (1,'AOP103');
insert into prodaja values (1,'AM100');
insert into prodaja values (1,'AM101');
insert into prodaja values (1,'AM102');
insert into prodaja values (1,'AM103');


































