package Cafe_Order;

import java.sql.*;
import java.util.Scanner;

public class Delete_order {
    public static void Delete(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
        	System.out.println("*** Enter starters for main meal and ColdDrinks for Drinks to cancel ***");
        	System.out.println(" Table Name: ");
            String tableName = sc.nextLine();
            System.out.println("Item Table No: ");
            int tableno = sc.nextInt();
            
           
            

            String sql=("DELETE FROM "+tableName + " WHERE TableNo = " + tableno);

            System.out.println("✅ Item Deleted successfully.");
            System.out.println();
            System.out.println("Check Item");
            
           
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            String tb="starters";
            if(tb=="starters") {
            	 
            ResultSet rs = stmt.executeQuery(" SELECT * FROM starters");
            

            System.out.printf("\n%-5s %-5s %-10s %-5s\n", "ItemName", "Quantity", "Dips", "TableNo");
            while (rs.next()) {
                System.out.printf("%-10s %-5d %-15s %-5d\n",
                        rs.getString("ItemName"), rs.getInt("Quantity"),
                        rs.getString("Dips"), rs.getInt("TableNo"));
            }
            }
            else {
            	ResultSet rs1 = stmt.executeQuery(" SELECT * FROM ColdDrinks");
                

                System.out.printf("\n%-5s %-5s %-10s %-5s\n", "ItemName", "Quantity", "Size", "TableNo");
                while (rs1.next()) {
                    System.out.printf("%-10s %-5d %-15s %-5d\n",
                            rs1.getString("ItemName"), rs1.getInt("Quantity"),
                            rs1.getString("Size"), rs1.getInt("TableNo"));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}