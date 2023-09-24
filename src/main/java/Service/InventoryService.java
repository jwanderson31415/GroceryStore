package Service;

import DAO.InventoryDAO;
import Exceptions.NoProductFoundException;
import Model.Inventory;
import Util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private InventoryDAO inventoryDAO;

    private String item;
    private double price;
    private int quantity;


    public InventoryService(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    public void addItem(Inventory inventory) {
        inventoryDAO.addItem(inventory);
    }

    public Inventory getItemByName(String item) {
        Inventory inventory = inventoryDAO.getItemByName(item);
        return inventory;
    }

    public void deleteItem(String item) { inventoryDAO.deleteItem(item); }

    public void updateItem(Inventory inventory){ inventoryDAO.updateItem(inventory); }

    public List<Inventory> getAllItems() {
        List<Inventory> allItems = inventoryDAO.getAllItems();
        return allItems;
    }

}