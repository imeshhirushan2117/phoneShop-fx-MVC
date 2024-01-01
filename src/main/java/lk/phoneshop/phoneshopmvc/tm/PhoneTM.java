package lk.phoneshop.phoneshopmvc.tm;

/**
 * Created By Imesh Hirushan
 * Project Name : phoneShopMVC
 * Package Name : lk.phoneshop.phoneshopmvc.tm
 * Date : Jan 1, 2024
 * Time : 4:31 PM
 */
public class PhoneTM {
    private String id;
    private String brand;
    private String module;
    private int ram;
    private double price;

    public PhoneTM() {
    }

    public PhoneTM(String id, String brand, String module, int ram, double price) {
        this.id = id;
        this.brand = brand;
        this.module = module;
        this.ram = ram;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PhoneTM{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", module='" + module + '\'' +
                ", ram=" + ram +
                ", price=" + price +
                '}';
    }
}
