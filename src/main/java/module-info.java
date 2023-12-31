module lk.phoneshop.phoneshopmvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires mysql.connector.j;

    opens lk.phoneshop.phoneshopmvc to javafx.fxml;
    exports lk.phoneshop.phoneshopmvc;

    exports lk.phoneshop.phoneshopmvc.controller;
    opens lk.phoneshop.phoneshopmvc.controller to javafx.fxml;

}