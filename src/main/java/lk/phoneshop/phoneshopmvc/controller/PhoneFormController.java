package lk.phoneshop.phoneshopmvc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.phoneshop.phoneshopmvc.HelloApplication;
import lk.phoneshop.phoneshopmvc.module.PhoneModule;
import lk.phoneshop.phoneshopmvc.to.Phone;

import java.io.IOException;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.controller
 * Date : Jan 1, 2024
 * Time : 3:24 PM
 */
public class PhoneFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblPhone;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtModule;

    @FXML
    private TextField txtPhoneId;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtRam;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashBoard-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void deleted(ActionEvent event) {
        System.out.println("deleted");
    }

    @FXML
    void save(ActionEvent event) {
        String pid = txtPhoneId.getText();
        String brand = txtBrand.getText();
        String module = txtModule.getText();
        int ram = Integer.parseInt(txtRam.getText());
        double price = Double.parseDouble(txtPrice.getText());
        PhoneModule.savePhone(new Phone(pid,brand,module,ram,price));
        clear();
    }

    @FXML
    void update(ActionEvent event) {
        System.out.println("update");
    }


    public void clear(){
        txtBrand.clear();
        txtModule.clear();
        txtRam.clear();
        txtPrice.clear();
    }

}
