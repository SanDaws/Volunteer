package com.volunteer.views;

import java.util.Scanner;

import com.volunteer.entities.User;

public class InterMenu {
    private User user;
    public Scanner sc = new Scanner(System.in);
    public InterMenu() {
        int choice;

        do {
            System.out.println("""
                1. projects
                2. inscriptions
                3. Exit
                """);
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    // Option two logic
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        sc.close();

    }
    

}
