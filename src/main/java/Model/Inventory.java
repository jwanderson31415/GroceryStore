package Model;

import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Inventory {
    private String item;
    private double price;
    private int quantity;
    Connection conn = ConnectionSingleton.getConnection();

    public Inventory(){

    }
    public Inventory(String item, double price, int quantity){
        this.item = item;
        this.price= price;
        this.quantity = quantity;
    }
    public Inventory(String item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }
    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

//    public Connection getConn() {
//        return conn;
//    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "item='" + item + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
