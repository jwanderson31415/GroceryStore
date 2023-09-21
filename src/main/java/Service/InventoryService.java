package Service;

import DAO.InventoryDAO;
import DAO.InventoryDAO;
import Model.Inventory;

import java.util.List;

public class InventoryService {
    private InventoryDAO inventoryDAO;

    private String item;
    private double price;
    private int quantity;


    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

//    public List<Inventory> getInventory(InventoryDAO){
//        List<Inventory> inventoryList = inventoryDAO.query(author);
//        return inventoryList;
//    }


    public void addItem(Inventory item) {
    }

    public List<Inventory> getItemByName(String item) {
        return null;
    }

    public void deleteItem(String item) {

    }

    public void updateItem(Inventory item){

    }

}