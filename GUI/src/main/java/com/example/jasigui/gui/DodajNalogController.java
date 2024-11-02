package com.example.jasigui.gui;

import com.example.jasigui.db.JASIUmetni;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DodajNalogController {

    @FXML
    public DatePicker datumDP;
    @FXML
    public TextField idZaduzenjaTF;
    private int idZaduzenje;
    private int idZaposleni;

    public DodajNalogController(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public DodajNalogController(int idZaduzenje, int idZaposleni) {
        this.idZaduzenje = idZaduzenje;
        this.idZaposleni = idZaposleni;
    }

    @FXML
    public void initialize() {
        if (idZaduzenje != 0) {
            idZaduzenjaTF.setText(String.valueOf(idZaduzenje));
            idZaduzenjaTF.setEditable(false);
        }
    }

    @FXML
    public void onActionDodaj(ActionEvent actionEvent) {
        try {
            idZaduzenje = Integer.parseInt(idZaduzenjaTF.getText());
            LocalDate localDate = datumDP.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date datum = Date.from(instant);
            Platform.runLater(() -> {
                JASIUmetni umetni = new JASIUmetni();
                umetni.kreirajRadniNalog(idZaduzenje, idZaposleni, new java.sql.Date(datum.getTime()));
                ((Stage) datumDP.getScene().getWindow()).close();
            });
        } catch (NumberFormatException | NullPointerException ignored) {

        }
    }
}
