package Model;

import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Inventory {
    private String Item;
    private double Price;
    private int Quantity;
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
    public void Add(String item, double price, int quantity) throws SQLException {
        PreparedStatement ps1 = conn.prepareStatement("insert into table1 (Item, Price, Quantity) values (" + item + ", " + price + ", " + quantity + ")");
        ps1.executeUpdate();
    }


}
