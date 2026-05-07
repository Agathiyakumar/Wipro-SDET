package Cafe_Order;

import java.sql.*;
import java.util.Scanner;

import Cafe_Order.Starters;
import Cafe_Order.CodDrink;
import Cafe_Order.Bevarage;
import Cafe_Order.IceCream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("👤 Username: ");
        String username = sc.nextLine();
        System.out.print("🔒 Password: ");
        String password = sc.nextLine();

        if (!LoginService.login(username, password)) {
            System.out.println("❌ Login failed. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n****** Cafe Order Receive Menu ******");
            System.out.println("1.->Main meal Order<-");
            System.out.println("2.->ColdDrink<-");
//            System.out.println("3.->Bevarage<-");
//            System.out.println("4.->IceCream<-");
//            System.out.println("5.->Menu<-");
            System.out.println("3.->Delete Order<-");
            System.out.println("4.->Exit<-");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> Starters.registerStarter(sc);
                case 2 -> CodDrink.registerDrink(sc);
//                case 3 -> Bevarage.registerBeaver(sc);
//                case 4 -> IceCream.registerIce(sc);
//                case 5->Menu.menuview();
                case 3->Delete_order.Delete(sc);
                case 4	 -> {
                    System.out.println("🔚 Goodbye!");
                    return;
                }
                default -> System.out.println("❓ Invalid option");
            }
        }
        
        
}
}


