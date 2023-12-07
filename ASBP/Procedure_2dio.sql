use auto_servis;

delimiter $$
create procedure kreiranje_novog_zaduzenja(in pidRadnaStanica int, in pidZaposleni int, in pbrojSasije varchar(17), in pzahtjevaniDatumZavrsetka date,in popis varchar(500))
begin
	declare radnaStanicaPostoji, zaposleniPostoji, voziloPostoji boolean default false;
    
    select	(count(*) > 0 ) into radnaStanicaPostoji
    from	radna_stanica
    where 	idRadnaStanica = pidRadnaStanica;
    
    select	(count(*) > 0 ) into zaposleniPostoji	-- zaposleni koji evidentira novo zaduzenje
    from	zaposleni
    where 	idZaposleni = pidZaposleni;
    
    select	(count(*) > 0 ) into voziloPostoji
    from	vozilo
    where 	brojSasije = pbrojSasije;
    
    if radnaStanicaPostoji and zaposleniPostoji and voziloPostoji then
		insert into zaduzenje (idRadnaStanica, idZaposleni, brojSasije, datumPreuzimanjaVozila, zahtjevaniDatumZavrsetka, opis)
        values (pidRadnaStanica,pidZaposleni,pbrojSasije,date(sysdate()),pzahtjevaniDatumZavrsetka,popis);
    end if;
end $$
delimiter ;

delimiter $$
create procedure kreiranje_novog_radnog_naloga(in pidZaduzenje int, in pidZaposleni int, in pocekivaniDatumZavrsetka date)
begin
	declare zaduzenjePostoji, zaposleniPostoji boolean default false;
	
    select	(count(*)>0) into zaduzenjePostoji
    from 	zaduzenje
    where 	idZaduzenje = pidZaduzenje;
    
    select	(count(*)>0) into zaposleniPostoji
    from 	zaposleni
    where 	idZaposleni = pidZaposleni;
    
    if zaduzenjePostoji and zaposleniPostoji then
		insert into radni_nalog (idZaduzenje, idZaposleni, ocekivaniDatumZavrsetka, statusNaloga) values (pidZaduzenje, pidZaposleni, pocekivaniDatumZavrsetka,'u obradi'); 
    end if;
end $$
delimiter ;

delimiter $$
create procedure dodavanje_usluge_na_radniNalog(in pidRadniNalog int, in psifra varchar(50))
begin
	declare radniNalogPostoji, uslugaPostoji boolean default false;
    declare cenaUsluge decimal(8,2);
    
    select	(count(*) > 0) into radniNalogPostoji
    from 	radni_nalog
    where	idRadniNalog = pidRadniNalog;
    
    select	(count(*) > 0) into uslugaPostoji
    from 	usluga
    where	sifra = psifra;
    
    select	cena into cenaUsluge
    from 	usluga
    where	sifra = psifra;
    
    if radniNalogPostoji and uslugaPostoji then
		insert into ukljucuje_uslugu (sifra,idRadniNalog,cena) values (psifra,pidRadniNalog,cenaUsluge);
    end if;
end $$
delimiter ;

delimiter $$
create procedure dodavanje_artikla_na_radniNalog(in pidRadniNalog int, in psifra varchar(50), in pkolicina decimal(8,2))
begin
	declare radniNalogPostoji, artikalPostoji, dovoljnoNaStanju boolean default false;
    declare cenaArtikla decimal(8,2);
    
    select	(count(*) > 0) into radniNalogPostoji
    from 	radni_nalog
    where	idRadniNalog = pidRadniNalog;
    
    select	(count(*) > 0) into artikalPostoji
    from 	artikal
    where	sifra = psifra;
    
    select	cena into cenaArtikla
    from 	artikal
    where	sifra = psifra;
    
    select	(kolicinaNaStanju >= pkolicina) into dovoljnoNaStanju
    from 	artikal
    where	sifra = psifra;
    
    if radniNalogPostoji and artikalPostoji and dovoljnoNaStanju then
		insert into ukljucuje_artikal (sifra,idRadniNalog,cena,kolicina) values (psifra,pidRadniNalog,cenaArtikla,pkolicina);
    end if;
end $$
delimiter ;

delimiter $$
create procedure brisanje_usluge_sa_radnogNaloga(in pidRadniNalog int, in psifra varchar(50))
begin
	delete from ukljucuje_uslugu 
    where		sifra = psifra and idRadniNalog = pidRadniNalog;
end $$
delimiter ;

delimiter $$
create procedure brisanje_artikla_sa_radnogNaloga(in pidRadniNalog int, in psifra varchar(50))
begin
	delete from ukljucuje_artikal
    where		sifra = psifra and idRadniNalog = pidRadniNalog;
end $$
delimiter ;










