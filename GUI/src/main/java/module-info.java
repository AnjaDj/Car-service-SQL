module com.example.jasigui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.jasigui to javafx.fxml;
    exports com.example.jasigui;
    exports com.example.jasigui.gui;
    exports  com.example.jasigui.model;
    opens com.example.jasigui.gui to javafx.fxml;
}