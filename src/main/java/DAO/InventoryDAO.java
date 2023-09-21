package DAO;

import Model.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryServiceDAO {

    private Connection conn;

    public InventoryDAO(Connection conn){
        this.conn = conn;
    }


    public void insertItem(Inventory inventory) throws SQLException {

        PreparedStatement ps1 = conn.prepareStatement("insert into grocery_store (Item, Price, Quantity) values (?, ?, ?)");
        ps1.setString(1, inventory.getItem());
        ps1.setDouble(2, inventory.getPrice());
        ps1.setInt(3, inventory.getQuantity());

        ps1.executeUpdate();
    }

    public List<Inventory> query(String author){
        List<Inventory> inventoryList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("select * from grocery_list");
//            ps.setString(1, author);
            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                int dbAuthor = rs.getInt("author_id");
//                String dbTitle = rs.getString("title");
//                int yearMade = rs.getInt("year_made");
//                int paintingId = rs.getInt("painting_id");
//                Inventory dbInventory = new Inventory(paintingId, dbTitle, dbAuthor);
//                inventoryList.add(dbInventory);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return inventoryList;

}
