package com.example.jasigui.gui;

import com.example.jasigui.db.JASIBrisi;
import com.example.jasigui.db.JASIPrikazi;
import com.example.jasigui.model.RadniNalog;
import com.example.jasigui.model.Zaduzenje;
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

public class NaloziController {
    @FXML
    public TableView naloziTable;
    @FXML
    public MenuItem uslugeMenuItem;
    @FXML
    public MenuItem artikliMenuItem;
    @FXML
    public MenuItem obrisiMenuItem;
    private int idZaduzenje;

    private int idZaposleni;

    public NaloziController(int idZaduzenje, int idZaposleni) {
        this.idZaduzenje = idZaduzenje;
        this.idZaposleni = idZaposleni;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            JASIPrikazi prikazi = new JASIPrikazi();
            popuniTabeluNaloga(prikazi.prikazSvihRadnihNalogaZaNekoZaduzenje(idZaduzenje));
        });
    }

    private void popuniTabeluNaloga(List<RadniNalog> nalozi) {
        ((TableColumn) naloziTable.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory<>("id"));
        ((TableColumn) naloziTable.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory<>("status"));
        ((TableColumn) naloziTable.getColumns().get(2)).setCellValueFactory(new PropertyValueFactory<>("datumZavrsetka"));
        ((TableColumn) naloziTable.getColumns().get(3)).setCellValueFactory(new PropertyValueFactory<>("idZaduzenje"));
        //((TableColumn) zaduzenjaTable.getColumns().get(7)).setCellValueFactory(new PropertyValueFactory<>("hasInsurance"));
        naloziTable.getItems().clear();
        nalozi.stream().forEach(n -> naloziTable.getItems().add(n));
    }

    @FXML
    public void onActionDodajNalog(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(NaloziController.class.getResource("dodaj-nalog.fxml"));
            loader.setControllerFactory(c -> new DodajNalogController(idZaduzenje, idZaposleni));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Dodavanje naloga");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluNaloga(new JASIPrikazi().prikazSvihRadnihNalogaZaNekoZaduzenje(idZaduzenje)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onCMRequested(ContextMenuEvent contextMenuEvent) {
        if (naloziTable.getSelectionModel().getSelectedItem() == null) {
            uslugeMenuItem.setDisable(true);
            artikliMenuItem.setDisable(true);
            obrisiMenuItem.setDisable(true);
        } else {
            uslugeMenuItem.setDisable(false);
            artikliMenuItem.setDisable(false);
            obrisiMenuItem.setDisable(false);
        }
    }

    @FXML
    public void onClickUslugeMI(ActionEvent actionEvent) {
        RadniNalog nalog = (RadniNalog) naloziTable.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(NaloziController.class.getResource("usluge.fxml"));
            loader.setControllerFactory(c -> new UslugeController(nalog.getId()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Usluge");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluNaloga(new JASIPrikazi().prikazSvihRadnihNalogaZaNekoZaduzenje(idZaduzenje)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onClickArtikliMI(ActionEvent actionEvent) {
        RadniNalog nalog = (RadniNalog) naloziTable.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(NaloziController.class.getResource("artikli.fxml"));
            loader.setControllerFactory(c -> new ArtikliController(nalog.getId()));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Artikli");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluNaloga(new JASIPrikazi().prikazSvihRadnihNalogaZaNekoZaduzenje(idZaduzenje)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onClickObrisiMI(ActionEvent actionEvent) {
        RadniNalog nalog = (RadniNalog) naloziTable.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            JASIBrisi brisi = new JASIBrisi();
            JASIPrikazi prikazi = new JASIPrikazi();
            brisi.brisiRadniNalog(nalog.getId());
            popuniTabeluNaloga(prikazi.prikazSvihRadnihNalogaZaNekoZaduzenje(idZaduzenje));
        });
    }
}
