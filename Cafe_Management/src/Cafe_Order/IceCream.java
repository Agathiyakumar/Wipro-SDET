package Cafe_Order;

import java.sql.*;
import java.util.Scanner;

public class IceCream {
    public static void registerIce(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Item Name: ");
            String ItemName = sc.nextLine();
            sc.nextLine();
            System.out.println("Quantity: ");
            int Quantity = sc.nextInt();
            sc.nextLine();
            System.out.println("Size: ");
            String Size = sc.nextLine();
            System.out.println("Table no: ");
            int TableNo = sc.nextInt();
            

            String sql = "INSERT INTO Icecream (ItemName, Quantity, Size, TableNo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemName);
            ps.setInt(2, Quantity);
            ps.setString(3, Size); 
            ps.setInt(4, TableNo);
   
            ps.executeUpdate();

            System.out.println("✅ item registered successfully.");
            System.out.println();
            System.out.println("Check the Item");
            
            String sql1 = "SELECT * FROM Icecream";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            System.out.printf("\n%-30s %-20s %-5s %-10s\n", "ItemName", "Quantity", "Size", "TableNo");
            while (rs.next()) {
                System.out.printf("%-30s %-20d %-5s %-10d\n",
                        rs.getString("ItemName"), rs.getInt("Quantity"),
                        rs.getString("Size"), rs.getInt("TableNo"));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void viewPatients() {
//        try (Connection con = DBConnection.getConnection()) {
//            String sql = "SELECT * FROM Icecream";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            System.out.printf("\n%-5s %-20s %-5s %-10s %-15s %-30s\n", "ItemName", "Quantity", "Size", "TableNo");
//            while (rs.next()) {
//                System.out.printf("%-5d %-20s %-5d %-10s %-15s %-30s\n",
//                        rs.getString("ItemName"), rs.getInt("Quantity"),
//                        rs.getString("Size"), rs.getInt("TableNo"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
