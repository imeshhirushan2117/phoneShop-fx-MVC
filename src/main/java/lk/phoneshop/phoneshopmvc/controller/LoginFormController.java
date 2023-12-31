package lk.phoneshop.phoneshopmvc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.phoneshop.phoneshopmvc.HelloApplication;
import lk.phoneshop.phoneshopmvc.db.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.Base64;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.controller
 * Date : Dec 31, 2023
 * Time : 10:13 PM
 */
public class LoginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void SignIn(ActionEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM user WHERE email=?");
            stm.setObject(1,email);
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()){
                byte[] decodedBytes = Base64.getDecoder().decode(resultSet.getString(3));
                String decodedString = new String(decodedBytes);


                if(password.equals(decodedString)){
                    Stage stage = (Stage) this.root.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashBoard-form.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                }else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("LogIn Failed");
                    alert.setContentText("Place try agan ! ");
                    alert.show();
                    System.out.println("login failed");
                }

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void Signup(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

}
