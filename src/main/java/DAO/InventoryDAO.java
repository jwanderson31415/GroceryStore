package DAO;

import Model.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    private Connection conn;

    public InventoryDAO(Connection conn) {
        this.conn = conn;
    }


    public void addItem(Inventory inventory) {
        try {
        PreparedStatement ps = conn.prepareStatement("insert into grocery_store (Item, Price, Quantity) values (?, ?, ?)");
        ps.setString(1, inventory.getItem());
        ps.setDouble(2, inventory.getPrice());
        ps.setInt(3, inventory.getQuantity());
        ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Inventory getItemByName(String item) {
        try{
            PreparedStatement ps = conn.prepareStatement("select * from grocery_store where item = ?");
            ps.setString(1, item);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String dbItem = rs.getString("item");
                double dbPrice = rs.getDouble("price");
                int dbQuantity = rs.getInt("quantity");
                Inventory dbInventory = new Inventory(dbItem, dbPrice, dbQuantity);
                return dbInventory;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteItem(String item) {
        try{
            PreparedStatement ps = conn.prepareStatement("delete grocery_store where Item = ?");
            ps.setString(1, item);
            ps.executeUpdate();
        }catch(SQLException e){
         e.printStackTrace();
        }
    }

    public void updateItem(Inventory inventory){
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE grocery_store set quantity=? where Item = ?");
            ps.setInt(1, inventory.getQuantity());
            ps.setString(2, inventory.getItem());
            ps.executeUpdate();
        }catch(SQLException e)
        {e.printStackTrace();
        }


    }
    public List<Inventory> getAllItems() {
        List<Inventory> inventoryList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from grocery_store");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String dbItem = rs.getString("item");
                double dbPrice = rs.getDouble("price");
                int dbQuantity = rs.getInt("quantity");
                Inventory dbInventory = new Inventory(dbItem, dbPrice, dbQuantity);
                inventoryList.add(dbInventory);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return inventoryList;
    }
}
