package lk.phoneshop.phoneshopmvc.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.phoneshop.phoneshopmvc.HelloApplication;
import lk.phoneshop.phoneshopmvc.db.DBConnection;
import lk.phoneshop.phoneshopmvc.module.PhoneModule;
import lk.phoneshop.phoneshopmvc.tm.PhoneTM;
import lk.phoneshop.phoneshopmvc.to.Phone;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.controller
 * Date : Jan 1, 2024
 * Time : 3:24 PM
 */
public class PhoneFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<PhoneTM> tblPhone;

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
        String pid = txtPhoneId.getText();
        PhoneModule.deletedPhone(pid);
        txtPhoneId.clear();
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
        String pId = txtPhoneId.getText();
        String brand = txtBrand.getText();
        String module = txtModule.getText();
        int ram = Integer.parseInt(txtRam.getText());
        double price = Double.parseDouble(txtPrice.getText());
        PhoneModule.updatePhone(new Phone(pId,brand,module,ram,price));

        clear();
    }


    @FXML
    void search(ActionEvent event) {
        String pid = txtSearch.getText();
        Phone search = PhoneModule.search(pid);
        txtPhoneId.setText(search.getBrand());
        txtBrand.setText(search.getBrand());
        txtModule.setText(search.getModule());
        txtRam.setText(String.valueOf(search.getRam()));
        txtPrice.setText(String.valueOf(search.getPrice()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblPhone.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblPhone.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblPhone.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("module"));
        tblPhone.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ram"));
        tblPhone.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
        ArrayList<Phone> allPhone = PhoneModule.getAllPhone();
        ArrayList<PhoneTM> tms = new ArrayList<>();

        for(Phone p: allPhone){
            tms.add(new PhoneTM(p.getId(),p.getBrand(),p.getModule(),p.getRam(),p.getPrice()));
        }
        tblPhone.setItems(FXCollections.observableArrayList(tms));



    }

    public void clear(){
        txtPhoneId.clear();
        txtBrand.clear();
        txtModule.clear();
        txtRam.clear();
        txtPrice.clear();
    }



}
