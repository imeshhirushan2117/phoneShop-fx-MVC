package lk.phoneshop.phoneshopmvc.to;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.to
 * Date : Jan 1, 2024
 * Time : 10:24 PM
 */
public class Customer {
    private String cusId;
    private String name;
    private String address;
    private String nic;
    private String contact;
    private double salary;

    public Customer() {
    }

    public Customer(String cusId, String name, String address, String nic, String contact, double salary) {
        this.setCusId(cusId);
        this.setName(name);
        this.setAddress(address);
        this.setNic(nic);
        this.setContact(contact);
        this.setSalary(salary);
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId='" + cusId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                ", salary=" + salary +
                '}';
    }
}
