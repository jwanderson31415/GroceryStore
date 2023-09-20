package Model;

import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventory {
//    private String Item;
//    private double Price;
//    private int Quantity;
    private String item;
    private double price;
    private int quantity;
    public Inventory(String item, double price, int quantity){
        this.item = item;
        this.price= price;
        this.quantity = quantity;
    }
   // public Inventory(String x1, double x2, )
    Connection conn = ConnectionSingleton.getConnection();
//    public void Add(String item, double price, int quantity) throws SQLException {
//        PreparedStatement ps1 = conn.prepareStatement("insert into grocery_store (Item, Price, Quantity) values ("?, ?, ?");
//
//        ps1.executeUpdate();
//    }



    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Connection getConn() {
        return conn;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "item='" + item + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", conn=" + conn +
                '}';
    }
}
