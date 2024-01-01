package lk.phoneshop.phoneshopmvc.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.phoneshop.phoneshopmvc.HelloApplication;
import lk.phoneshop.phoneshopmvc.module.CustomerModule;
import lk.phoneshop.phoneshopmvc.tm.CustomerTM;
import lk.phoneshop.phoneshopmvc.tm.PhoneTM;
import lk.phoneshop.phoneshopmvc.to.Customer;
import lk.phoneshop.phoneshopmvc.to.Phone;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.controller
 * Date : Jan 1, 2024
 * Time : 10:13 AM
 */
public class CustomerFormController implements Initializable {


    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CustomerTM> tblCustomer;

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
        String cusId = txtCusId.getText();
        CustomerModule.deletedCustomer(cusId);

    }

    @FXML
    void save(ActionEvent event) {
        String cusId = txtCusId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String nic = txtNic.getText();
        String contact = txtContact.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        CustomerModule.saveCustomer(new Customer(cusId, name, address, nic, contact, salary));
        clear();

    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cusId"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblCustomer.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("salary"));

        ArrayList<Customer> allCustomer = CustomerModule.getAllCustomer();
        ArrayList<CustomerTM> tms = new ArrayList<>();

        for(Customer c: allCustomer){
            tms.add(new CustomerTM(c.getCusId(),c.getName(),c.getAddress(),c.getNic(),c.getContact(),c.getSalary()));
        }

        tblCustomer.setItems(FXCollections.observableArrayList(tms));

    }

    public void clear() {

        txtCusId.clear();
        txtName.clear();
        txtAddress.clear();
        txtNic.clear();
        txtContact.clear();
        txtSalary.clear();

    }

}
