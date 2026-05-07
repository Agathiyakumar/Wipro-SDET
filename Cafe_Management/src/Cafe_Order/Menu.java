package Cafe_Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {

	 public static void menuview() {
	        try (Connection con = DBConnection.getConnection()) {
	            
	            

	            String sql1 = "SELECT * FROM Menu";
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql1);
	            System.out.println();
	            
	            System.out.println("*****************************************");
	            System.out.println( "Starters\t\t Drinks\t\t Bevarage\t Icecream");
	            while (rs.next()) {
	                String starterss=rs.getString("starterss");
	                String Drinks=rs.getString("Drinks");
	                String Bevarages=rs.getString("Bevarages");
	                String Icecreams=rs.getString("Icecreams");
	                System.out.println(starterss+"\t"+ Drinks+"\t\t"+ Bevarages+"\t	"+Icecreams);
	                
	            }
	            System.out.println("**************************************");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
}