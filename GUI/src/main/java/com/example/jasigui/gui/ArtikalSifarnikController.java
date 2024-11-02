package com.example.jasigui.gui;

import com.example.jasigui.db.JASIUmetni;
import com.example.jasigui.model.Artikal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ArtikalSifarnikController {
    @FXML
    public TextField sifraTF;
    @FXML
    public TextField nazivTF;
    @FXML
    public TextField cijenaTF;
    @FXML
    public TextField kolicinaTF;
    @FXML
    public Button dodajBtn;
    @FXML
    public Label naslovLbl;

    private Artikal artikal;

    public ArtikalSifarnikController() {

    }

    public ArtikalSifarnikController(Artikal artikal) {
        this.artikal = artikal;
    }

    @FXML
    public void initialize() {
        if (artikal != null) {
            sifraTF.setText(artikal.getSifra());
            nazivTF.setText(artikal.getNaziv());
            cijenaTF.setText(String.valueOf(artikal.getCijena()));
            kolicinaTF.setText(String.valueOf(artikal.getKolicina()));
            sifraTF.setEditable(false);
            nazivTF.setEditable(false);
            dodajBtn.setText("Izmijenite");
            //naslovLbl.setText("Izmjena artikla");
        }
    }

    @FXML
    public void onActionDodaj(ActionEvent actionEvent) {
        if (artikal == null) {
            try {
                String sifra = sifraTF.getText();
                String naziv = nazivTF.getText();
                double cijena = Double.parseDouble(cijenaTF.getText());
                double kolicina = Double.parseDouble(kolicinaTF.getText());
                if (!sifra.isEmpty() && !naziv.isEmpty()) {
                    new JASIUmetni().dodajArtikalUSifarnik(sifra, naziv, cijena, kolicina);
                    ((Stage) sifraTF.getScene().getWindow()).close();
                }
            } catch (NullPointerException | NumberFormatException ignored) {

            }
        } else {
            try {
                String sifra = sifraTF.getText();
                double kolicina = Double.parseDouble(kolicinaTF.getText());
                double cijena = Double.parseDouble(cijenaTF.getText());
                new JASIUmetni().idiUNabavku(sifra, kolicina, cijena);
                ((Stage) sifraTF.getScene().getWindow()).close();
            } catch (NullPointerException | NumberFormatException ignored) {

            }
        }
    }
}
