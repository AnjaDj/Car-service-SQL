use auto_servis;

create trigger kreiranje_racuna after insert 
on 		zaduzenje
for each row
insert into racun (iznos,datum,idZaduzenje) values (0, date(sysdate()) , new.idZaduzenje);

-- Zbog ogranicenja referencijalnog tipa, brisanje zaduzenja rezultovace brisanjem njemu pripadajuceg racuna te nam za taj scenario nije potreban triger

create trigger azuriranje_racuna_dodavanjem_usluge after insert
on 		ukljucuje_uslugu
for each row
update 	racun
set 	iznos = iznos + new.cena
where 	idZaduzenje IN (select 		rn.idZaduzenje
						from 		radni_nalog rn
                        where		rn.idRadniNalog = new.idRadniNalog
);

create trigger azuriranje_racuna_brisanjem_usluge after delete
on 		ukljucuje_uslugu
for each row
update 	racun
set 	iznos = iznos - old.cena
where 	idZaduzenje IN (select 		rn.idZaduzenje
						from		radni_nalog rn
                        where		rn.idRadniNalog = old.idRadniNalog
);

create trigger azuriranje_racuna_dodavanjem_artikla after insert
on 		ukljucuje_artikal
for each row
update 	racun
set 	iznos = iznos + (new.cena * new.kolicina)
where 	idZaduzenje IN (select 		rn.idZaduzenje
						from 		radni_nalog rn
                        where		rn.idRadniNalog = new.idRadniNalog
);

create trigger azuriranje_racuna_brisanjem_artikla after delete
on 		ukljucuje_artikal
for each row
update 	racun
set 	iznos = iznos - (old.cena * old.kolicina)
where 	idZaduzenje IN (select 		rn.idZaduzenje
						from 		radni_nalog rn
                        where		rn.idRadniNalog = old.idRadniNalog
);

drop trigger azuriranje_racuna_brisanjem_naloga;

create trigger azuriranje_stanja_u_skladistu_dec after insert
on 			ukljucuje_artikal
for each row
update		artikal
set			kolicinaNaStanju = kolicinaNaStanju - new.kolicina
where		sifra = new.sifra;

create trigger azuriranje_stanja_u_skladistu_inc after delete
on 			ukljucuje_artikal
for each row
update		artikal
set			kolicinaNaStanju = kolicinaNaStanju + old.kolicina
where		sifra = old.sifra;


