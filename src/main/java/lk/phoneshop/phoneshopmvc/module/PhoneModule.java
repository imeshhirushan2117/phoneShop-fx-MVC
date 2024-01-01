package lk.phoneshop.phoneshopmvc.module;

import javafx.scene.control.Alert;
import lk.phoneshop.phoneshopmvc.db.DBConnection;
import lk.phoneshop.phoneshopmvc.to.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.module
 * Date : Jan 1, 2024
 * Time : 3:41 PM
 */
public class PhoneModule {
    public static boolean savePhone(Phone phone) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO phone VALUES (?,?,?,?,?)");
            stm.setObject(1, phone.getId());
            stm.setObject(2, phone.getBrand());
            stm.setObject(3, phone.getModule());
            stm.setObject(4, phone.getRam());
            stm.setObject(5, phone.getPrice());

            int executed = stm.executeUpdate();
            System.out.println(executed);

            if (executed == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Save");
                alert.setContentText("Phone Saveed ! ");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Place Try Agan! ");
                alert.show();
            }

            return executed > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Phone> getAllPhone(){
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM phone");
            ResultSet resultSet = stm.executeQuery();
            ArrayList<Phone> phones = new ArrayList<>();

            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setId(resultSet.getString(1));
                phone.setBrand(resultSet.getString(2));
                phone.setModule(resultSet.getString(3));
                phone.setRam(resultSet.getInt(4));
                phone.setPrice(resultSet.getDouble(5));

                phones.add(phone);
            }

            return phones;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
