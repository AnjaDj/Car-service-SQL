-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema auto_servis
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema auto_servis
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `auto_servis` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `auto_servis` ;

-- -----------------------------------------------------
-- Table `auto_servis`.`MESTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`MESTO` (
  `PTTbroj` INT NOT NULL,
  `naziv` VARCHAR(50) NOT NULL,
  `region` VARCHAR(50) NOT NULL,
  `drzava` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`PTTbroj`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`STRANKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`STRANKA` (
  `idStranka` INT NOT NULL AUTO_INCREMENT,
  `adresa` VARCHAR(50) NULL,
  `PTTbroj` INT NULL,
  PRIMARY KEY (`idStranka`),
  INDEX `fk_STRANKA_MESTO1_idx` (`PTTbroj` ASC) VISIBLE,
  CONSTRAINT `FK_STRANKA_MESTO`
    FOREIGN KEY (`PTTbroj`)
    REFERENCES `auto_servis`.`MESTO` (`PTTbroj`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`VOZILO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`VOZILO` (
  `brojSasije` VARCHAR(17) NOT NULL,
  `registracionaOznaka` VARCHAR(20) NULL,
  `marka` VARCHAR(20) NOT NULL,
  `model` VARCHAR(20) NOT NULL,
  `vrsta` VARCHAR(3) NOT NULL,
  `idStranka` INT NOT NULL,
  PRIMARY KEY (`brojSasije`),
  INDEX `fk_VOZILO_STRANKA1_idx` (`idStranka` ASC) VISIBLE,
  CONSTRAINT `FK_VOZILO_STRANKA`
    FOREIGN KEY (`idStranka`)
    REFERENCES `auto_servis`.`STRANKA` (`idStranka`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`INDIVIDUA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`INDIVIDUA` (
  `ime` VARCHAR(50) NOT NULL,
  `prezime` VARCHAR(50) NOT NULL,
  `idStranka` INT NOT NULL,
  PRIMARY KEY (`idStranka`),
  CONSTRAINT `FK_INDIVIDUA_STRANKA`
    FOREIGN KEY (`idStranka`)
    REFERENCES `auto_servis`.`STRANKA` (`idStranka`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`PREDUZECE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`PREDUZECE` (
  `naziv` VARCHAR(50) NOT NULL,
  `idStranka` INT NOT NULL,
  PRIMARY KEY (`idStranka`),
  CONSTRAINT `idStranka`
    FOREIGN KEY (`idStranka`)
    REFERENCES `auto_servis`.`STRANKA` (`idStranka`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`RADNA_STANICA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`RADNA_STANICA` (
  `idRadnaStanica` INT NOT NULL,
  `PTTbroj` INT NOT NULL,
  `adresa` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idRadnaStanica`),
  INDEX `fk_RADNA_STANICA_MESTO1_idx` (`PTTbroj` ASC) VISIBLE,
  CONSTRAINT `FK_RADNA_STANICA_MESTO`
    FOREIGN KEY (`PTTbroj`)
    REFERENCES `auto_servis`.`MESTO` (`PTTbroj`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`ZAPOSLENI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`ZAPOSLENI` (
  `idZaposleni` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(50) NOT NULL,
  `prezime` VARCHAR(50) NOT NULL,
  `idRadnaStanica` INT NOT NULL,
  `radno_zvanje` VARCHAR(50) NOT NULL,
  `PTTbroj` INT NULL,
  `korisnickoIme` VARCHAR(50) NOT NULL,
  `korisnickaLozinka` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idZaposleni`),
  INDEX `fk_ZAPOSLENI_RADNA_STANICA1_idx` (`idRadnaStanica` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_MESTO1_idx` (`PTTbroj` ASC) VISIBLE,
  UNIQUE INDEX `korisnickoIme_UNIQUE` (`korisnickoIme` ASC) VISIBLE,
  CONSTRAINT `FK_ZAPOSLENI_RADNA_STANICA`
    FOREIGN KEY (`idRadnaStanica`)
    REFERENCES `auto_servis`.`RADNA_STANICA` (`idRadnaStanica`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_ZAPOSLENI_MESTO`
    FOREIGN KEY (`PTTbroj`)
    REFERENCES `auto_servis`.`MESTO` (`PTTbroj`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`USLUGA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`USLUGA` (
  `sifra` VARCHAR(50) NOT NULL,
  `naziv` VARCHAR(50) NOT NULL,
  `cena` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`sifra`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`ARTIKAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`ARTIKAL` (
  `sifra` VARCHAR(50) NOT NULL,
  `naziv` VARCHAR(50) NOT NULL,
  `cena` DECIMAL(8,2) NOT NULL,
  `kolicinaNaStanju` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`sifra`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`VRSI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`VRSI` (
  `idRadnaStanica` INT NOT NULL,
  `sifra` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idRadnaStanica`, `sifra`),
  INDEX `fk_RADNA_STANICA_has_USLUGA_USLUGA1_idx` (`sifra` ASC) VISIBLE,
  INDEX `fk_RADNA_STANICA_has_USLUGA_RADNA_STANICA1_idx` (`idRadnaStanica` ASC) VISIBLE,
  CONSTRAINT `FK_VRSI_RADNA_STANICA`
    FOREIGN KEY (`idRadnaStanica`)
    REFERENCES `auto_servis`.`RADNA_STANICA` (`idRadnaStanica`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `sifra`
    FOREIGN KEY (`sifra`)
    REFERENCES `auto_servis`.`USLUGA` (`sifra`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`PRODAJA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`PRODAJA` (
  `idRadnaStanica` INT NOT NULL,
  `sifra` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idRadnaStanica`, `sifra`),
  INDEX `fk_RADNA_STANICA_has_ARTIKAL_ARTIKAL1_idx` (`sifra` ASC) VISIBLE,
  INDEX `fk_RADNA_STANICA_has_ARTIKAL_RADNA_STANICA1_idx` (`idRadnaStanica` ASC) VISIBLE,
  CONSTRAINT `FK_PRODAJA_RADNA_STANICA`
    FOREIGN KEY (`idRadnaStanica`)
    REFERENCES `auto_servis`.`RADNA_STANICA` (`idRadnaStanica`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_PRODAJA_ARTIKAL`
    FOREIGN KEY (`sifra`)
    REFERENCES `auto_servis`.`ARTIKAL` (`sifra`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`ZADUZENJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`ZADUZENJE` (
  `idZaduzenje` INT NOT NULL AUTO_INCREMENT,
  `datumPreuzimanjaVozila` DATE NOT NULL,
  `opis` VARCHAR(500) NULL,
  `brojSasije` VARCHAR(17) NOT NULL,
  `idRadnaStanica` INT NOT NULL,
  `idZaposleni` INT NULL,
  `zahtjevaniDatumZavrsetka` DATE NULL,
  PRIMARY KEY (`idZaduzenje`),
  INDEX `fk_ZADUZENJE_VOZILO1_idx` (`brojSasije` ASC) VISIBLE,
  INDEX `fk_ZADUZENJE_RADNA_STANICA1_idx` (`idRadnaStanica` ASC) VISIBLE,
  INDEX `fk_ZADUZENJE_ZAPOSLENI1_idx` (`idZaposleni` ASC) VISIBLE,
  CONSTRAINT `FK_ZADUZENJE_VOZILO`
    FOREIGN KEY (`brojSasije`)
    REFERENCES `auto_servis`.`VOZILO` (`brojSasije`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_ZADUZENJE_RADNA_STANICA`
    FOREIGN KEY (`idRadnaStanica`)
    REFERENCES `auto_servis`.`RADNA_STANICA` (`idRadnaStanica`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_ZADUZENJE_ZAPOSLENI`
    FOREIGN KEY (`idZaposleni`)
    REFERENCES `auto_servis`.`ZAPOSLENI` (`idZaposleni`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`RACUN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`RACUN` (
  `idRacun` INT NOT NULL AUTO_INCREMENT,
  `iznos` DECIMAL(8,2) NOT NULL DEFAULT 0,
  `datum` DATE NOT NULL,
  `idZaduzenje` INT NOT NULL,
  PRIMARY KEY (`idRacun`),
  INDEX `fk_RACUN_ZADUZENJE2_idx` (`idZaduzenje` ASC) VISIBLE,
  CONSTRAINT `FK_RACUN_ZADUZENJE`
    FOREIGN KEY (`idZaduzenje`)
    REFERENCES `auto_servis`.`ZADUZENJE` (`idZaduzenje`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

alter table `auto_servis`.`RACUN` modify column iznos DECIMAL(8,2) NULL DEFAULT 0;

-- -----------------------------------------------------
-- Table `auto_servis`.`RADNI_NALOG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`RADNI_NALOG` (
  `idRadniNalog` INT NOT NULL AUTO_INCREMENT,
  `statusNaloga` VARCHAR(50) NOT NULL,
  `ocekivaniDatumZavrsetka` DATE NULL,
  `idZaduzenje` INT NOT NULL,
  `idZaposleni` INT NULL,
  PRIMARY KEY (`idRadniNalog`),
  INDEX `fk_RADNI_NALOG_ZADUZENJE1_idx` (`idZaduzenje` ASC) VISIBLE,
  INDEX `fk_RADNI_NALOG_ZAPOSLENI1_idx` (`idZaposleni` ASC) VISIBLE,
  CONSTRAINT `FK_RADNI_NALOG_ZADUZENJE`
    FOREIGN KEY (`idZaduzenje`)
    REFERENCES `auto_servis`.`ZADUZENJE` (`idZaduzenje`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_RADNI_NALOG_ZAPOSLENI`
    FOREIGN KEY (`idZaposleni`)
    REFERENCES `auto_servis`.`ZAPOSLENI` (`idZaposleni`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`UKLJUCUJE_USLUGU`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`UKLJUCUJE_USLUGU` (
  `sifra` VARCHAR(50) NOT NULL,
  `idRadniNalog` INT NOT NULL,
  `cena` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`sifra`, `idRadniNalog`),
  INDEX `fk_USLUGA_has_RADNI_NALOG_RADNI_NALOG1_idx` (`idRadniNalog` ASC) VISIBLE,
  INDEX `fk_USLUGA_has_RADNI_NALOG_USLUGA1_idx` (`sifra` ASC) VISIBLE,
  CONSTRAINT `FK_UKLJUCUJE_USLUGU_USLUGA`
    FOREIGN KEY (`sifra`)
    REFERENCES `auto_servis`.`USLUGA` (`sifra`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_UKLJUCUJE_USLUGU_RADNI_NALOG`
    FOREIGN KEY (`idRadniNalog`)
    REFERENCES `auto_servis`.`RADNI_NALOG` (`idRadniNalog`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`UKLJUCUJE_ARTIKAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`UKLJUCUJE_ARTIKAL` (
  `sifra` VARCHAR(50) NOT NULL,
  `idRadniNalog` INT NOT NULL,
  `cena` DECIMAL(8,2) NOT NULL,
  `kolicina` DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (`sifra`, `idRadniNalog`),
  INDEX `fk_ARTIKAL_has_RADNI_NALOG_RADNI_NALOG1_idx` (`idRadniNalog` ASC) VISIBLE,
  INDEX `fk_ARTIKAL_has_RADNI_NALOG_ARTIKAL1_idx` (`sifra` ASC) VISIBLE,
  CONSTRAINT `FK_UKLJUCUJE_ARTIKAL_ARTIKAL`
    FOREIGN KEY (`sifra`)
    REFERENCES `auto_servis`.`ARTIKAL` (`sifra`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `FK_UKLJUCUJE_ARTIKAL_RADNI_NALOG`
    FOREIGN KEY (`idRadniNalog`)
    REFERENCES `auto_servis`.`RADNI_NALOG` (`idRadniNalog`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `auto_servis`.`ZADUZENJE_NA_NALOGU`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `auto_servis`.`ZADUZENJE_NA_NALOGU` (
  `idZaposleni` INT NOT NULL,
  `idRadniNalog` INT NOT NULL,
  `opisPosla` VARCHAR(200) NULL,
  PRIMARY KEY (`idZaposleni`, `idRadniNalog`),
  INDEX `fk_ZAPOSLENI_has_RADNI_NALOG_RADNI_NALOG2_idx` (`idRadniNalog` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_has_RADNI_NALOG_ZAPOSLENI2_idx` (`idZaposleni` ASC) VISIBLE,
  CONSTRAINT `FK_ZADUZENJE_NA_NALOGU_ZAPOSLENI`
    FOREIGN KEY (`idZaposleni`)
    REFERENCES `auto_servis`.`ZAPOSLENI` (`idZaposleni`)
    ON DELETE CASCADE
    ON UPDATE CASCADE ,
  CONSTRAINT `FK_ZADUZENJE_NA_NALOGU_RADNI_NALOG`
    FOREIGN KEY (`idRadniNalog`)
    REFERENCES `auto_servis`.`RADNI_NALOG` (`idRadniNalog`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
