package Model;

import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inventory {
    private String Item;
    private double Price;
    private int Quantity;

    public Inventory(String x1, double x2, )
    Connection conn = ConnectionSingleton.getConnection();
    public void Add(String x1, double x2, int x3) throws SQLException {
        PreparedStatement ps1 = conn.prepareStatement("insert into table1 (Item, Price, Quantity) values (x, 4.99, 10)");
        ps1.executeUpdate();
    }
}
