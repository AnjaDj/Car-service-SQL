package com.example.jasigui.gui;

import com.example.jasigui.db.JASIUmetni;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DodajZaduzenjeController {
    @FXML
    public TextArea opisTA;
    @FXML
    public TextField brojSasijeTF;
    @FXML
    public TextField stanicaTF;
    @FXML
    public DatePicker datumDP;
    private int idZaposleni;

    public DodajZaduzenjeController(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public void onActionDodaj(ActionEvent actionEvent) {
        try {
            String opis = opisTA.getText();
            String brojSasije = brojSasijeTF.getText();
            int stanica = Integer.parseInt(stanicaTF.getText());
            LocalDate localDate = datumDP.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date datum = Date.from(instant);
            if (!opis.isEmpty() && !brojSasije.isEmpty()) {
                Platform.runLater(() -> {
                    JASIUmetni umetni = new JASIUmetni();
                    umetni.kreirajZaduzenje(stanica, idZaposleni, brojSasije, new java.sql.Date(datum.getTime()), opis);
                    ((Stage) datumDP.getScene().getWindow()).close();
                });
            }
        } catch (NumberFormatException | NullPointerException ignored) {

        }
    }
}
