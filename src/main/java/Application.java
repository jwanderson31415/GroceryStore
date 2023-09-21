import Controller.Controller;
import DAO.InventoryDAO;
import Model.Inventory;
import Service.InventoryService;
import Util.ConnectionSingleton;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
//        this line is just for testing that your tables get set up correctly
//        if not, you'll get a stack trace
        //ConnectionSingleton.getConnection();
//        this line is for starting the javalin server
        //Controller controller = new Controller();
        //controller.getAPI().start();

        Connection conn = ConnectionSingleton.getConnection();
        InventoryDAO inventoryDAO = new InventoryDAO(conn);
        InventoryService inventoryService = new InventoryService(inventoryDAO);

        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("Would you like to inventory: (1)Insert (2)Query (3)Delete (4)Update");

            int response = scan.nextInt();

            if(response==1){
                // add item to service class
                System.out.println("(1) ADD: Enter item: ");
                String item = scan.next();
                System.out.println("(1) ADD: Enter price: ");
                double price = scan.nextDouble();
                System.out.println("(1) ADD: Enter quantity: ");
                int quantity = scan.nextInt();
                Inventory inventory = new Inventory(item, price, quantity);
                inventoryService.addItem(inventory);
            }
            else if(response == 2){
                // query item from service class
                System.out.println("(2) QUERY: Enter name of item:");
                String item = scan.next();
                List<Inventory> inventoryList = inventoryService.getItemByName(item);
                System.out.println(inventoryList);
            }
            else if(response == 3){
                // delete item using service class
                System.out.println("(3) DELETE: Enter item: ");
                String item = scan.next();

            }
            else if(response == 4){
                // update item using service class
                System.out.println("(4) UPDATE: Enter item: ");
                String item = scan.next();
                System.out.println("(4) UPDATE: Enter price: ");
                double price = scan.nextDouble();
                System.out.println("(4) UPDATE: Enter quantity: ");
                int quantity = scan.nextInt();
                Inventory inventory = new Inventory(item, price, quantity);

            }
            else{
                // invalid choice
                System.out.println("Invalid choice: '" + response + "'");
            }

        }

//        PreparedStatement ps2 = conn.prepareStatement("select * from table1");
//        ResultSet rs2 = ps2.executeQuery();
//
//        while(rs2.next()){
//            System.out.println(rs2.getString("Item"));
//            System.out.println(rs2.getDouble("Price"));
//            System.out.println(rs2.getInt("Quantity"));
//
//        }


    }
}


/**
 * sql vs no sql
 * sql has the ability to strictly define tables and relate tables to each ohter
 * (referential integrity, eg a 'teachers' table may be related logically to a 'classrooms' table)
 *
 * noSQL is more scalable and more easily converted into a distributed system than sql
 * however
 */