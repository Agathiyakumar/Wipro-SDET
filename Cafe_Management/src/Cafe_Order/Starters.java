package Cafe_Order;

import java.sql.*;
import java.util.Scanner;

public class Starters {
    public static void registerStarter(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Item Name: ");
            String ItemName = sc.nextLine();
            
            System.out.println("Quantity: ");
            int Quantity = sc.nextInt();
            sc.nextLine();
            System.out.println("Dips: ");
            String Dips = sc.nextLine();
            System.out.println("Table no: ");
            int TableNo = sc.nextInt();
            

            String sql = "INSERT INTO starters (ItemName, Quantity, Dips, TableNo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ItemName);
            ps.setInt(2, Quantity);
            ps.setString(3, Dips); 
            ps.setInt(4, TableNo);
   
            ps.executeUpdate();

            System.out.println("✅ Item registered successfully.");
            System.out.println();
            System.out.println("Check Item");
            String sql1 = "SELECT * FROM starters";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);

            System.out.printf("\n%-5s %-5s %-15s %-5s\n", "ItemName", "Quantity", "Dips", "TableNo");
            while (rs.next()) {
                System.out.printf("%-10s %-5d %-15s %-5d\n",
                        rs.getString("ItemName"), rs.getInt("Quantity"),
                        rs.getString("Dips"), rs.getInt("TableNo"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void viewPatients() {
//        try (Connection con = DBConnection.getConnection()) {
//            String sql = "SELECT * FROM starters";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            System.out.printf("\n%-5s %-20s %-5s %-10s %-15s %-30s\n", "ItemName", "Quantity", "Dips", "TableNo");
//            while (rs.next()) {
//                System.out.printf("%-5d %-20s %-5d %-10s %-15s %-30s\n",
//                        rs.getString("ItemName"), rs.getInt("Quantity"),
//                        rs.getString("Dips"), rs.getInt("TableNo"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
