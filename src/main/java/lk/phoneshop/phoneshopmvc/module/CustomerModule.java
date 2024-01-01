package lk.phoneshop.phoneshopmvc.module;

import javafx.scene.control.Alert;
import lk.phoneshop.phoneshopmvc.db.DBConnection;
import lk.phoneshop.phoneshopmvc.to.Customer;
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
 * Time : 10:23 PM
 */
public class CustomerModule {
    public static boolean saveCustomer(Customer customer){
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?)");

            stm.setObject(1,customer.getCusId());
            stm.setObject(2,customer.getName());
            stm.setObject(3,customer.getAddress());
            stm.setObject(4,customer.getNic());
            stm.setObject(5,customer.getContact());
            stm.setObject(6,customer.getSalary());

            int executed = stm.executeUpdate();
            System.out.println(executed);

            if (executed == 1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Save");
                alert.setContentText("Customer Saveed ! ");
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
    public static ArrayList<Customer> getAllCustomer(){

        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = stm.executeQuery();
            ArrayList<Customer> customers = new ArrayList<>();

            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setCusId(resultSet.getString(1));
                customer.setName(resultSet.getString(2));
                customer.setAddress(resultSet.getString(3));
                customer.setNic(resultSet.getString(4));
                customer.setContact(resultSet.getString(5));
                customer.setSalary(resultSet.getDouble(5));

                customers.add(customer);
            }

         return customers;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean deletedCustomer(String id){
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("DELETE FROM customer WHERE cid=?");

            stm.setObject(1,id);
            int executed = stm.executeUpdate();
            System.out.println(executed);
            if(executed == 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Deleted");
                alert.setContentText("Phone Deleted ! ");
                alert.show();

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Place Try Agan! ");
                alert.show();
            }

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean updateCustomer(Customer customer){
        return true;
    }
    public static Customer search(Customer customer){
        return null;
    }
}
