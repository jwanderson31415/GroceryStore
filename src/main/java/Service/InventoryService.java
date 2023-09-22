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

/**
 *  Testing
 */


//
//    /**
//     * return true if item exists in items, false otherwise
//     * @param name
//     * @return
//     */
//
//    List<Inventory> items;
//    public InventoryService(){
//        items = new ArrayList<>();
//        LogUtil.log.info("Setting up inventory service");
//    }
//    public boolean doesItemExist(String testItem) {
//        LogUtil.log.info("Searching if item exists : "+ testItem);
//        if(findItem(testItem)==null){
//            return false;
//        }else{
//            return true;
//        }
//
//    }
//
//    public Inventory findItem(String findItem){
//        for(Inventory itemExistence : items){
//            if(itemExistence.getItem().equals(findItem)){
//                return itemExistence;
//            }
//        }
//        return null;
//    }



}