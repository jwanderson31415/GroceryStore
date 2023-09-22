package Service;

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

    public void addItem(Inventory inventory) {
        inventoryDAO.addItem(inventory);
        //Inventory dbInventory = inventory;

        //inventoryDAO.addItem(inventory);

//        if it's null, i assume it doesn't exist, and i proceed with the insert.
//        if (dbInventory == null) {
////            set the fkey that we just found by name for inserting the painting
//            //inventory.setAuthorFkey(authorId);
//            inventoryDAO.addItem(inventory);
//        }else{
////            if it does exist, throw an exception to the user input layer so it may inform the user.
//           // throw new PaintingAlreadyExistsException();
//        }

    }

    public List<Inventory> getItemByName(String item) {
        List<Inventory> inventory = inventoryDAO.getItemByName(item);
        return inventory;
    }

    public void deleteItem(String item) { inventoryDAO.deleteItem(item); }

    public void updateItem(Inventory inventory){ inventoryDAO.updateItem(inventory); }

    public List<Inventory> getAllItems() {
        List<Inventory> allItems = inventoryDAO.getAllItems();
        return allItems;
    }

}