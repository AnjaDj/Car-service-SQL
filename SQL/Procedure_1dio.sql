use auto_servis;

create procedure usluge_radneStanice(in pidRadnaStanica int)  
	select 		idRadnaStanica as IdRadneStanice, v.sifra as SifraUsluge, naziv as NazivUsluge, cena as CenaUsluge 
    from 		vrsi v
    inner join 	usluga u on v.sifra = u.sifra
    where 		idRadnaStanica = pidRadnaStanica;

create procedure artikli_radneStanice(in pidRadnaStanica int)
	select 		idRadnaStanica as IdRadneStanice, a.sifra as SifraArtikla, naziv as NazivArtikla, cena as CenaArtikla 
    from 		prodaja p
    inner join 	artikal a on p.sifra = a.sifra
    where 		idRadnaStanica = pidRadnaStanica;

delimiter $$ 
create procedure dodaj_uslugu(in psifra varchar(50), in pnaziv varchar(50), in pcena decimal(8,2))
begin
	declare vecPostoji boolean default false;
    
    select	(count(*)>0) into vecPostoji
    from 	usluga
    where	sifra = psifra;
    
    if not vecPostoji then
		insert into usluga (sifra,naziv,cena) values (psifra,pnaziv,pcena);
    end if;
end $$
delimiter ;

delimiter $$  
create procedure dodaj_artikal(in psifra varchar(50), in pnaziv varchar(50), in pcena decimal(8,2), in kolicina decimal(8,2))
begin
	declare vecPostoji boolean default false;
    
    select	(count(*)>0) into vecPostoji
    from 	artikal
    where	sifra = psifra;
    
    if not vecPostoji then
		insert into artikal (sifra,naziv,cena,kolicinaNaStanju) values (psifra,pnaziv,pcena,kolicina);
    end if;
end $$
delimiter ;

delimiter $$  
create procedure nabavka(in psifra varchar(50), in kolicina decimal(8,2), in pcena decimal(8,2))
begin
	declare nePostoji boolean default false;
    
    select	(count(*)<>1) into nePostoji
    from 	artikal
    where	sifra = psifra;
    
    if not nePostoji and kolicina > 0 then
		update	artikal
        set 	kolicinaNaStanju = kolicinaNaStanju + kolicina, cena=pcena
        where 	sifra = psifra;
    end if;
end $$
delimiter ;

delimiter $$  
create procedure izmeni_uslugu(in psifra varchar(50), in pcena decimal(8,2))
begin
	declare nePostoji boolean default false;
    
    select	(count(*)<>1) into nePostoji
    from 	usluga
    where	sifra = psifra;
    
    if not nePostoji and kolicina > 0 then
		update	usluga
        set 	cena=pcena
        where 	sifra = psifra;
    end if;
end $$
delimiter ;













