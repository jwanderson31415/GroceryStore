import Controller.Controller;
import DAO.InventoryServiceDAO;
import Model.Inventory;
import Service.InventoryService;
import Util.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        InventoryServiceDAO inventoryDAO = new InventoryServiceDAO(conn);
        Scanner scan = new Scanner(System.in);
        boolean exit = false;

        InventoryService inventoryService = new InventoryService(inventoryDAO);

        while(!exit){
            System.out.println("Would you like to to inventory 1)Insert, 2)Query, 3)Delete");
            int response = scan.nextInt();
            if(response==1){
                System.out.println("Enter Item name to be added: ");
                String item = scan.next();
                System.out.println("Enter Price: ");
                double price = scan.nextDouble();
                System.out.println("Enter Quantity: ");
                int quantity = scan.nextInt();
                Inventory inventory = new Inventory(item, price, quantity);
            }
            else if(response == 2){
                System.out.println("Enter name of item:");
                String item = scan.next();
                List<Inventory> inventoryList = inventoryService.getItem();
                System.out.println(inventoryList);
            }

        }
// test
        PreparedStatement ps2 = conn.prepareStatement("select * from table1");
        ResultSet rs2 = ps2.executeQuery();

        while(rs2.next()){
            System.out.println(rs2.getString("Item"));
            System.out.println(rs2.getDouble("Price"));
            System.out.println(rs2.getInt("Quantity"));

        }


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