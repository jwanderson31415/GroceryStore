package Service;

import DAO.InventoryServiceDAO;
import Model.Inventory;

import java.util.List;

public class InventoryService {

    private String item;

    private double price;

    private int quantity;
    private InventoryServiceDAO inventoryDAO;

    public InventoryService(InventoryServiceDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    public List<Inventory> getInventory(InventoryServiceDAO){
        List<Inventory> inventoryList = inventoryDAO.query(author);
        return inventoryList;
    }


    public void Delete(String name){
        //delete item
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

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
