package com.example.library;

import java.util.Scanner;

public class LibraryManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("WELCOME TO LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=".repeat(60) + "\n");

            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine().trim();
            
            System.out.print("Enter User Name: ");
            String userName = scanner.nextLine().trim();
            
            System.out.print("Enter Number of Books Issued: ");
            int booksIssued = getIntInput(scanner);
            
            System.out.print("Enter Number of Borrowing Days: ");
            int borrowingDays = getIntInput(scanner);

            User user = new User(userId, userName, booksIssued, borrowingDays);
            Library library = new Library(user);

            if (booksIssued > 0) {
                System.out.println("\n--- Enter Book Details ---");
                for (int i = 0; i < booksIssued; i++) {
                    System.out.println("\nBook " + (i + 1) + ":");
                    
                    System.out.print("  Enter Book ID: ");
                    String bookId = scanner.nextLine().trim();
                    
                    System.out.print("  Enter Book Title: ");
                    String title = scanner.nextLine().trim();
                    
                    System.out.print("  Enter Author: ");
                    String author = scanner.nextLine().trim();
                    
                    System.out.print("  Enter ISBN: ");
                    String isbn = scanner.nextLine().trim();

                    Book book = new Book(bookId, title, author, isbn);
                    library.addBook(book);
                }
            }

            library.displayLibraryDetails();
            
            if (user.calculateLateFine() > 0) {
                System.out.println("⚠️  WARNING: You have outstanding fines!");
                System.out.println("📋 Status: " + user.getBorrowingStatus());
            } else {
                System.out.println("✓ You are within the borrowing limit. No fines applicable.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value < 0) {
                    System.out.print("Please enter a non-negative number: ");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
