package com.example.library;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;

    public Book(String bookId, String title, String author, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + " | Title: " + title + 
               " | Author: " + author + " | ISBN: " + isbn;
    }
}
