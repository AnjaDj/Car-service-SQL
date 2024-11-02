use auto_servis;

create view 		prikaz_ukupnogIznosaUsluga_za_radniNalog (idRadniNalog, idZaduzenje, ukupanIznosUsluga) as
select				rn.idRadniNalog, rn.idZaduzenje, sum(uu.cena) as ukupanIznosUsluga
from				radni_nalog rn
left outer join 	ukljucuje_uslugu uu on uu.idRadniNalog = rn.idRadniNalog
group by			rn.idRadniNalog;

create view 		prikaz_ukupnogIznosaArtikala_za_radniNalog (idRadniNalog, idZaduzenje, ukupanIznosArtikala) as
select				rn.idRadniNalog, rn.idZaduzenje, sum(uu.cena * uu.kolicina) as ukupanIznosArtikala
from				radni_nalog rn
left outer join 	ukljucuje_artikal uu on uu.idRadniNalog = rn.idRadniNalog
group by			rn.idRadniNalog;

