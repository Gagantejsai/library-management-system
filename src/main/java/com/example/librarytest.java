package com.example.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    
    private User user;
    private Library library;
    private Book book;

    @BeforeEach
    public void setUp() {
        user = new User("U001", "John Doe", 3, 16);
        library = new Library(user);
        book = new Book("B001", "Java Programming", "John Smith", "ISBN-001");
    }

    @Test
    public void testUserCreation() {
        assertEquals("U001", user.getUserId());
        assertEquals("John Doe", user.getUserName());
    }

    @Test
    public void testLateFineCalculation() {
        assertEquals(10.0, user.calculateLateFine());
    }

    @Test
    public void testNoLateFine() {
        User onTimeUser = new User("U002", "Jane Doe", 2, 10);
        assertEquals(0.0, onTimeUser.calculateLateFine());
    }

    @Test
    public void testBorrowingStatus() {
        assertEquals("LATE by 2 day(s)", user.getBorrowingStatus());
    }

    @Test
    public void testAddBook() {
        library.addBook(book);
        assertEquals(1, library.getIssuedBooks().size());
    }
}
