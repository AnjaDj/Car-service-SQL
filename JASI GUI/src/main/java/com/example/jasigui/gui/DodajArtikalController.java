package com.example.jasigui.gui;

import com.example.jasigui.db.JASIUmetni;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajArtikalController {

    @FXML
    public TextField nalogTF;
    @FXML
    public TextField sifraTF;
    @FXML
    public TextField kolicinaTF;

    private int idNalog;

    public DodajArtikalController(int idNalog) {
        this.idNalog = idNalog;
    }

    @FXML
    public void initialize() {
        nalogTF.setText(String.valueOf(idNalog));
        nalogTF.setEditable(false);
    }

    @FXML
    public void onActionDodaj(ActionEvent actionEvent) {
        try {
            idNalog = Integer.parseInt(nalogTF.getText());
            double kolicina = Double.parseDouble(kolicinaTF.getText());
            String sifra = sifraTF.getText();
            if (!sifra.isEmpty()) {
                Platform.runLater(() -> {
                    JASIUmetni umetni = new JASIUmetni();
                    umetni.dodajArtikalNaRadniNalog(idNalog, sifra, kolicina);
                    ((Stage) nalogTF.getScene().getWindow()).close();
                });
            }
        } catch (NumberFormatException | NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
