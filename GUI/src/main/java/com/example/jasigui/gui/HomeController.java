package com.example.jasigui.gui;

import com.example.jasigui.db.JASIBrisi;
import com.example.jasigui.db.JASIPrikazi;
import com.example.jasigui.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HomeController {
    @FXML
    public TableView<Zaduzenje> zaduzenjaTable;
    @FXML
    public TableView<RadniNalog> naloziTable;
    @FXML
    public MenuItem naloziMenuItem;
    @FXML
    public MenuItem obrisiZaduzenjeMenuItem;
    @FXML
    public MenuItem uslugeNalogMenuItem;
    @FXML
    public MenuItem artikliNalogMenuItem;
    @FXML
    public MenuItem obrisiNalogMenuItem;
    @FXML
    public TableView<Racun> racuniTable;
    @FXML
    public TableView<StavkaNalog> prometUslugaTable;
    @FXML
    public TableView<StavkaNalog> prometArtikalaTable;
    public TableView<Artikal> artikliTable;
    public TableView<Usluga> uslugeTable;
    public MenuItem izmjenaArtiklaMenuItem;
    public MenuItem obrisiArtikalMenuItem;
    public MenuItem izmjenaUslugaMenuItem;
    public MenuItem obrisiUsluguMenuItem;

    private int idZaposleni;

    public HomeController() {
        idZaposleni = 1;
    }

    public HomeController(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    @FXML
    public void initialize() {
        /* Platform.runLater(() -> {
            JASIPrikazi prikazi = new JASIPrikazi();
            popuniTabeluZaduzenja(prikazi.prikazSvihZaduzenja());
            popuniTabeluNaloga(prikazi.prikazSvihRadnihNaloga());
            popuniTabeluRacuna(prikazi.prikazSvihRacuna());
            popuniTabeluPrometStavki(prometUslugaTable, prikazi.prikazUkupnogIznosaPoNalozimaNaOsnovuUsluga());
            popuniTabeluPrometStavki(prometArtikalaTable, prikazi.prikazUkupnogIznosaPoNalozimaNaOsnovuArtikala());
            popuniTabeluUsluga(prikazi.sifarnikUsluga());
            popuniTabeluArtikala(prikazi.sifarnikArtikala());
        }); */
        popuniTabele();
    }

    private void popuniTabeluZaduzenja(List<Zaduzenje> zaduzenja) {
        zaduzenjaTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        zaduzenjaTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("opis"));
        zaduzenjaTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("datumPreuzimanja"));
        zaduzenjaTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("brojSasije"));
        zaduzenjaTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("datumZavrsetka"));
        zaduzenjaTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("idRadnaStanica"));
        zaduzenjaTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("idZaposleni"));
        zaduzenjaTable.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("racun"));
        zaduzenjaTable.getItems().clear();
        zaduzenja.stream().forEach(z -> zaduzenjaTable.getItems().add(z));
    }

    private void popuniTabeluNaloga(List<RadniNalog> nalozi) {
        naloziTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        naloziTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("status"));
        naloziTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("datumZavrsetka"));
        naloziTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("idZaduzenje"));
        naloziTable.getItems().clear();
        nalozi.stream().forEach(n -> naloziTable.getItems().add(n));
    }

    private void popuniTabeluRacuna(List<Racun> racuni) {
        racuniTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("idZaduzenje"));
        racuniTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("iznos"));
        racuniTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("datum"));
        racuniTable.getItems().clear();
        racuni.stream().forEach(r -> racuniTable.getItems().add(r));
    }

    private void popuniTabeluPrometStavki(TableView<StavkaNalog> tabela, List<StavkaNalog> stavke) {
        tabela.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("idZaduzenje"));
        tabela.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("idNalog"));
        tabela.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cijena"));
        tabela.getItems().clear();
        stavke.stream().forEach(s -> tabela.getItems().add(s));
    }

    private void popuniTabeluUsluga(List<Usluga> usluge) {
        uslugeTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sifra"));
        uslugeTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("naziv"));
        uslugeTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cijena"));
        uslugeTable.getItems().clear();
        usluge.stream().forEach(u -> uslugeTable.getItems().add(u));
    }

    private void popuniTabeluArtikala(List<Artikal> artikli) {
        artikliTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sifra"));
        artikliTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("naziv"));
        artikliTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cijena"));
        artikliTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        artikliTable.getItems().clear();
        artikli.stream().forEach(a -> artikliTable.getItems().add(a));
    }

    private void popuniTabele() {
        Platform.runLater(() -> {
            JASIPrikazi prikazi = new JASIPrikazi();
            popuniTabeluZaduzenja(prikazi.prikazSvihZaduzenja());
            popuniTabeluNaloga(prikazi.prikazSvihRadnihNaloga());
            popuniTabeluRacuna(prikazi.prikazSvihRacuna());
            popuniTabeluPrometStavki(prometUslugaTable, prikazi.prikazUkupnogIznosaPoNalozimaNaOsnovuUsluga());
            popuniTabeluPrometStavki(prometArtikalaTable, prikazi.prikazUkupnogIznosaPoNalozimaNaOsnovuArtikala());
            popuniTabeluUsluga(prikazi.sifarnikUsluga());
            popuniTabeluArtikala(prikazi.sifarnikArtikala());
        });
    }

    @FXML
    public void onClickAddZaduzenje(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("dodaj-zaduzenje.fxml"));
            loader.setControllerFactory(c -> new DodajZaduzenjeController(idZaposleni));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Dodavanje zaduzenja");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            popuniTabele();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onCMRequestedZaduzenja(ContextMenuEvent contextMenuEvent) {
        if (zaduzenjaTable.getSelectionModel().getSelectedItem() == null) {
            naloziMenuItem.setDisable(true);
            obrisiZaduzenjeMenuItem.setDisable(true);
        } else {
            naloziMenuItem.setDisable(false);
            obrisiZaduzenjeMenuItem.setDisable(false);
        }
    }

    public void onClickNaloziMI(ActionEvent actionEvent) {
        Zaduzenje zaduzenje = (Zaduzenje) zaduzenjaTable.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("nalozi.fxml"));
            loader.setControllerFactory(c -> new NaloziController(zaduzenje.getId(), idZaposleni));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Nalozi");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            popuniTabele();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onClickObrisiZaduzenje(ActionEvent actionEvent) {
        Zaduzenje zaduzenje = (Zaduzenje) zaduzenjaTable.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            JASIBrisi brisi = new JASIBrisi();
            brisi.brisiZaduzenje(zaduzenje.getId());
            popuniTabele();
        });
    }

    @FXML
    public void onClickUslugeNalogMI(ActionEvent actionEvent) {
        RadniNalog nalog = naloziTable.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(NaloziController.class.getResource("usluge.fxml"));
            loader.setControllerFactory(c -> new UslugeController(nalog.getId()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Usluge");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            popuniTabele();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onClickArtikliNalogMI(ActionEvent actionEvent) {
        RadniNalog nalog = naloziTable.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(NaloziController.class.getResource("artikli.fxml"));
            loader.setControllerFactory(c -> new ArtikliController(nalog.getId()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Artikli");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();
            popuniTabele();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onClickObrisiNalogMI(ActionEvent actionEvent) {
        RadniNalog nalog = naloziTable.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            JASIBrisi brisi = new JASIBrisi();
            JASIPrikazi prikazi = new JASIPrikazi();
            brisi.brisiRadniNalog(nalog.getId());
            popuniTabeluNaloga(prikazi.prikazSvihRadnihNaloga());
        });
    }

    public void onClickDodajNalog(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("dodaj-nalog.fxml"));
            loader.setControllerFactory(c -> new DodajNalogController(idZaposleni));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Dodavanje naloga");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            popuniTabele();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onCMRequestedNalozi(ContextMenuEvent contextMenuEvent) {
        if (naloziTable.getSelectionModel().getSelectedItem() == null) {
            uslugeNalogMenuItem.setDisable(true);
            artikliNalogMenuItem.setDisable(true);
            obrisiNalogMenuItem.setDisable(true);
        } else {
            uslugeNalogMenuItem.setDisable(false);
            artikliNalogMenuItem.setDisable(false);
            obrisiNalogMenuItem.setDisable(false);
        }
    }

    @FXML
    public void onCMRequestedUsluge(ContextMenuEvent contextMenuEvent) {
        if (uslugeTable.getSelectionModel().getSelectedItem() == null) {
            izmjenaUslugaMenuItem.setDisable(true);
            obrisiUsluguMenuItem.setDisable(true);
        } else {
            izmjenaUslugaMenuItem.setDisable(false);
            obrisiUsluguMenuItem.setDisable(false);
        }
    }

    @FXML
    public void onCMRequestedArtikli(ContextMenuEvent contextMenuEvent) {
        if (artikliTable.getSelectionModel().getSelectedItem() == null) {
            izmjenaArtiklaMenuItem.setDisable(true);
            obrisiArtikalMenuItem.setDisable(true);
        } else {
            izmjenaArtiklaMenuItem.setDisable(false);
            obrisiArtikalMenuItem.setDisable(false);
        }
    }

    @FXML
    public void onClickObrisiUsluguMI(ActionEvent actionEvent) {
        Usluga usluga = uslugeTable.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            JASIBrisi brisi = new JASIBrisi();
            JASIPrikazi prikazi = new JASIPrikazi();
            brisi.brisiUsluguIzSifarnika(usluga.getSifra());
            popuniTabeluUsluga(prikazi.sifarnikUsluga());
        });
    }

    public void onClickObrisiArtikalMI(ActionEvent actionEvent) {
        Artikal artikal = artikliTable.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            JASIBrisi brisi = new JASIBrisi();
            JASIPrikazi prikazi = new JASIPrikazi();
            brisi.brisiArtikalIzSifarnika(artikal.getSifra());
            popuniTabeluArtikala(prikazi.sifarnikArtikala());
        });
    }

    @FXML
    public void onClickDodajArtikal(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("artikal.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Dodavanje artikla");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluArtikala(new JASIPrikazi().sifarnikArtikala()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onClickDodajUslugu(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("usluga.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Dodavanje usluga");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluUsluga(new JASIPrikazi().sifarnikUsluga()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onClickNabavkaArtiklaMI(ActionEvent actionEvent) {
        Artikal artikal = artikliTable.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("artikal.fxml"));
            loader.setControllerFactory(c -> new ArtikalSifarnikController(artikal));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Izmjena artikla");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluArtikala(new JASIPrikazi().sifarnikArtikala()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onClickIzmjenaUslugeMI(ActionEvent actionEvent) {
        Usluga usluga = uslugeTable.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(HomeController.class.getResource("usluga.fxml"));
            loader.setControllerFactory(c -> new UslugaSifarnikController(usluga));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Izmjena usluge");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluUsluga(new JASIPrikazi().sifarnikUsluga()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
