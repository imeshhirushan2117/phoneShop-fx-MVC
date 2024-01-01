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
import lk.phoneshop.phoneshopmvc.module.CustomerModule;
import lk.phoneshop.phoneshopmvc.to.Customer;

import java.io.IOException;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.controller
 * Date : Jan 1, 2024
 * Time : 10:13 AM
 */
public class CustomerFormController {


    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtSearch;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashBoard-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void deleted(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        String cusId = txtCusId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();
        String contact = txtContact.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        CustomerModule.saveCustomer(new Customer(cusId,name,address,nic,contact,salary));


        clear();

    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    public void clear(){

        txtCusId.clear();
        txtName.clear();
        txtAddress.clear();
        txtNic.clear();
        txtContact.clear();
        txtSalary.clear();

    }
}
