package com.example.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> issuedBooks;
    private User user;

    public Library(User user) {
        this.user = user;
        this.issuedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        issuedBooks.add(book);
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public User getUser() {
        return user;
    }

    public void displayLibraryDetails() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=".repeat(60));
        
        System.out.println("\n" + user.toString());
        
        System.out.println("\n" + "-".repeat(60));
        System.out.println("ISSUED BOOKS:");
        System.out.println("-".repeat(60));
        
        if (issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
        } else {
            for (int i = 0; i < issuedBooks.size(); i++) {
                System.out.println((i + 1) + ". " + issuedBooks.get(i));
            }
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TOTAL FINE: ₹" + String.format("%.2f", user.calculateLateFine()));
        System.out.println("=".repeat(60) + "\n");
    }
}
