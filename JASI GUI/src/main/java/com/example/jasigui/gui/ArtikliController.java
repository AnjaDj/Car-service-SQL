package com.example.jasigui.gui;

import com.example.jasigui.db.JASIBrisi;
import com.example.jasigui.db.JASIPrikazi;
import com.example.jasigui.model.Artikal;
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

public class ArtikliController {
    @FXML
    public TableView artikliTable;
    @FXML
    public MenuItem obrisiMenuItem;
    private int idNalog;

    public ArtikliController(int idNalog) {
        this.idNalog = idNalog;
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> {
            JASIPrikazi prikazi = new JASIPrikazi();
            popuniTabeluArtikala(prikazi.prikazSvihArtikalaZaNekiRadniNalog(idNalog));
        });
    }

    private void popuniTabeluArtikala(List<Artikal> artikli) {
        ((TableColumn) artikliTable.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory<>("sifra"));
        ((TableColumn) artikliTable.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory<>("naziv"));
        ((TableColumn) artikliTable.getColumns().get(2)).setCellValueFactory(new PropertyValueFactory<>("cijena"));
        ((TableColumn) artikliTable.getColumns().get(3)).setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        ((TableColumn) artikliTable.getColumns().get(4)).setCellValueFactory(new PropertyValueFactory<>("idNalog"));
        //((TableColumn) zaduzenjaTable.getColumns().get(7)).setCellValueFactory(new PropertyValueFactory<>("hasInsurance"));
        artikliTable.getItems().clear();
        artikli.stream().forEach(a -> artikliTable.getItems().add(a));
    }

    @FXML
    public void onCMRequested(ContextMenuEvent contextMenuEvent) {
        obrisiMenuItem.setDisable(artikliTable.getSelectionModel().getSelectedItem() == null);
    }

    @FXML
    public void onObrisiMI(ActionEvent actionEvent) {
        Artikal artikal = (Artikal) artikliTable.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            JASIBrisi brisi = new JASIBrisi();
            brisi.brisiArtikalSaRadnogNaloga(artikal.getIdNalog(), artikal.getSifra());
            popuniTabeluArtikala(new JASIPrikazi().prikazSvihArtikalaZaNekiRadniNalog(artikal.getIdNalog()));
        });
    }

    public void onDodajArtikal(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(UslugeController.class.getResource("dodaj-artikal.fxml"));
            loader.setControllerFactory(c -> new DodajArtikalController(idNalog));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Dodavanje artikla");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.showAndWait();
            Platform.runLater(() -> popuniTabeluArtikala(new JASIPrikazi().prikazSvihArtikalaZaNekiRadniNalog(idNalog)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
