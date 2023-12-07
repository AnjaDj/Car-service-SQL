package com.example.jasigui.gui;

import com.example.jasigui.db.JASIUmetni;
import com.example.jasigui.model.Usluga;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UslugaSifarnikController {
    @FXML
    public TextField sifraTF;
    @FXML
    public TextField nazivTF;
    @FXML
    public TextField cijenaTF;
    @FXML
    public Button dodajBtn;

    private Usluga usluga;

    public UslugaSifarnikController() {

    }

    public UslugaSifarnikController(Usluga usluga){
        this.usluga = usluga;
    }

    @FXML
    public void initialize() {
        if (usluga != null) {
            sifraTF.setText(usluga.getSifra());
            nazivTF.setText(usluga.getNaziv());
            cijenaTF.setText(String.valueOf(usluga.getCijena()));
            sifraTF.setEditable(false);
            nazivTF.setEditable(false);
            dodajBtn.setText("Izmijenite");
            //naslovLbl.setText("Izmjena artikla");
        }
    }

    @FXML
    public void onActionDodaj(ActionEvent actionEvent) {
        if (usluga == null) {
            try {
                String sifra = sifraTF.getText();
                String naziv = nazivTF.getText();
                double cijena = Double.parseDouble(cijenaTF.getText());
                if (!sifra.isEmpty() && !naziv.isEmpty()) {
                    new JASIUmetni().dodajUsluguUSifarnik(sifra, naziv, cijena);
                    ((Stage) sifraTF.getScene().getWindow()).close();
                }
            } catch (NullPointerException | NumberFormatException ignored) {

            }
        } else {
            try {
                String sifra = sifraTF.getText();
                double cijena = Double.parseDouble(cijenaTF.getText());
                new JASIUmetni().izmijeniUslugu(sifra, cijena);
                ((Stage) sifraTF.getScene().getWindow()).close();
            } catch (NullPointerException | NumberFormatException ignored) {

            }
        }
    }
}
