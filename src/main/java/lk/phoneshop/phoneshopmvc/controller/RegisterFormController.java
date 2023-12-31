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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.controller
 * Date : Dec 31, 2023
 * Time : 10:42 PM
 */
public class RegisterFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtUid;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    void back(MouseEvent event) throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void register(ActionEvent event) {

        String uId = txtUid.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            String originalInput = password;
            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

            PreparedStatement stm = connection.prepareStatement("INSERT INTO user VALUES (?,?,?)");
            stm.setObject(1,uId);
            stm.setObject(2,email);
            stm.setObject(3,encodedString);

            int executed = stm.executeUpdate();
            System.out.println(executed);

            if (executed == 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Save");
                alert.setContentText("User saved ! ");
                alert.show();
                clear();

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Un Save");
                alert.setContentText("Place Try Agan! ");
                alert.show();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void clear(){
        txtUid.clear();
        txtEmail.clear();
        txtPassword.clear();
    }
}
