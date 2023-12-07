package com.example.jasigui.gui;

import com.example.jasigui.db.JASIBrisi;
import com.example.jasigui.db.JASIPrikazi;
import com.example.jasigui.model.RadniNalog;
import com.example.jasigui.model.Usluga;
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

public class UslugeController {

    @FXML
    public TableView uslugeTable;
    @FXML
    public MenuItem obrisiMenuItem;
    private int idNalog;

    public UslugeController(int idNalog) {
        this.idNalog = idNalog;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            JASIPrikazi prikazi = new JASIPrikazi();
            popuniTabeluUsluga(prikazi.prikazSvihUslugaZaNekiRadniNalog(idNalog));
        });
    }

    private void popuniTabeluUsluga(List<Usluga> usluge) {
        ((TableColumn) uslugeTable.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory<>("sifra"));
        ((TableColumn) uslugeTable.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory<>("naziv"));
        ((TableColumn) uslugeTable.getColumns().get(2)).setCellValueFactory(new PropertyValueFactory<>("cijena"));
        ((TableColumn) uslugeTable.getColumns().get(3)).setCellValueFactory(new PropertyValueFactory<>("idNalog"));
        uslugeTable.getItems().clear();
        usluge.stream().forEach(u -> uslugeTable.getItems().add(u));
    }

    @FXML
    public void onCMRequested(ContextMenuEvent contextMenuEvent) {
        obrisiMenuItem.setDisable(uslugeTable.getSelectionModel().getSelectedItem() == null);
    }

    @FXML
    public void onClickObrisiMI(ActionEvent actionEvent) {
        Usluga usluga = (Usluga) uslugeTable.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            JASIBrisi brisi = new JASIBrisi();
            brisi.brisiUsluguSaRadnogNaloga(usluga.getIdNalog(), usluga.getSifra());
            popuniTabeluUsluga(new JASIPrikazi().prikazSvihUslugaZaNekiRadniNalog(usluga.getIdNalog()));
        });
    }

    public void onDodajUslugu(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(UslugeController.class.getResource("dodaj-uslugu.fxml"));
            loader.setControllerFactory(c -> new DodajUsluguController(idNalog));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Dodavanje usluge");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluUsluga(new JASIPrikazi().prikazSvihUslugaZaNekiRadniNalog(idNalog)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
