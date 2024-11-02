package com.example.jasigui.gui;

import com.example.jasigui.db.JASIPrikazi;
import com.example.jasigui.db.JASIUmetni;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public PasswordField passwordPF;
    @FXML
    public TextField usernameTB;

    @FXML
    public void onActionPrijava(ActionEvent actionEvent) {
        try {
            String korisnickoIme = usernameTB.getText();
            String korisnickaLozinka = passwordPF.getText();
            if (!korisnickoIme.isEmpty() && !korisnickaLozinka.isEmpty()) {
                int idZaposleni = new JASIPrikazi().prijava(korisnickoIme, korisnickaLozinka);
                if (idZaposleni != -1) {
                    FXMLLoader loader = new FXMLLoader(LoginController.class.getResource("home.fxml"));
                    loader.setControllerFactory(c -> new HomeController(idZaposleni));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage newStage = new Stage();
                    newStage.setTitle("Dodavanje artikla");
                    newStage.setMaximized(true);
                    newStage.setScene(scene);
                    newStage.show();
                    ((Stage) passwordPF.getScene().getWindow()).close();
                }
            }
        } catch (NullPointerException | NumberFormatException | IOException ignored) {

        }
    }
}
