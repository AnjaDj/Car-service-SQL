use auto_servis;

delimiter $$ 
create procedure prijava (in pkorisnickoIme varchar(50),in pkorisnickaLozinka varchar(50), out pidZaposleni int, out postoji boolean)
begin
    select	(count(*)>0) into postoji
    from 	zaposleni
    where	korisnickoIme = pkorisnickoIme and korisnickaLozinka = pkorisnickaLozinka;
    
    if postoji then
    select idZaposleni into pidZaposleni
    from 	zaposleni
    where	korisnickoIme = pkorisnickoIme and korisnickaLozinka = pkorisnickaLozinka;
    end if;
    
end $$
delimiter ;

delimiter $$
create procedure brisanje_radnog_naloga(in pidRadniNalog int)
begin
	declare iznosUslugaZaNalog, iznosArtikalaZaNalog decimal(8,2) default 0;
    declare nalogPostoji boolean default false;
    declare pidZaduzenje int;
    
    select (count(*)>0) into nalogPostoji
    from radni_nalog
    where idRadniNalog = pidRadniNalog;
    
    if nalogPostoji then
		select	idZaduzenje into pidZaduzenje 
        from  	radni_nalog
        where 	idRadniNalog = pidRadniNalog;
    end if;
    
    if nalogPostoji then
		select ukupanIznosUsluga into iznosUslugaZaNalog
		from prikaz_ukupnogIznosaUsluga_za_radniNalog
		where idRadniNalog = pidRadniNalog;
    end if;
    
    if nalogPostoji then
		select ukupanIznosArtikala into iznosArtikalaZaNalog
		from prikaz_ukupnogIznosaArtikala_za_radniNalog
		where idRadniNalog = pidRadniNalog;
    end if;
    
    if nalogPostoji then
		update 	racun
        set 	iznos = iznos - iznosUslugaZaNalog - iznosArtikalaZaNalog
        where 	idZaduzenje = pidZaduzenje;
    end if;
    
    if nalogPostoji then
		delete from radni_nalog where idRadniNalog=pidRadniNalog;
    end if;
    
end $$
delimiter ;