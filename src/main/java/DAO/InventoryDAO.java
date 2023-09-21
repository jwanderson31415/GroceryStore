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
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into grocery_store (Item, Price, Quantity) values (?, ?, ?)");


        ps.setString(1, inventory.getItem());
        ps.setDouble(2, inventory.getPrice());
        ps.setInt(3, inventory.getQuantity());
        ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Inventory> getItemByName(String item) {
        List<Inventory> inventoryList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select item from grocery_store");
            ps.setString(1, item);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
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


    public Inventory queryItem(String item){
//        try{
//            PreparedStatement ps = conn.prepareStatement("select * from grocery_store");
//            ps.setString(1, item);
//
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                String dbItem = rs.getString("Item");
//                double dbPrice = rs.getDouble("Price");
//                int dbQuantity = rs.getInt("Quantity");
//                Inventory dbInventory = new Inventory();
//                return dbInventory;
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
        return null;
    }


    public void deleteItem(String item) {

    }

    public void updateItem(Inventory item){

    }


}
