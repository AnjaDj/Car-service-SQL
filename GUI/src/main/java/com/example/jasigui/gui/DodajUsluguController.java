package com.example.jasigui.gui;

import com.example.jasigui.db.JASIUmetni;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DodajUsluguController {

    @FXML
    public TextField nalogTF;
    @FXML
    public TextField sifraTF;
    int idNalog;

    public DodajUsluguController(int idNalog) {
        this.idNalog = idNalog;
    }

    @FXML
    public void initialize() {
        nalogTF.setText(String.valueOf(idNalog));
        nalogTF.setEditable(false);
    }

    public void onActionDodaj(ActionEvent actionEvent) {
        try {
            idNalog = Integer.parseInt(nalogTF.getText());
            String sifra = sifraTF.getText();
            if (!sifra.isEmpty()) {
                Platform.runLater(() -> {
                    JASIUmetni umetni = new JASIUmetni();
                    umetni.dodajUsluguNaRadniNalog(idNalog, sifra);
                    ((Stage) nalogTF.getScene().getWindow()).close();
                });
            }
        } catch (NumberFormatException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
