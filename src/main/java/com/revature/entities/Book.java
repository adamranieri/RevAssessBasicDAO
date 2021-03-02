package com.revature.entities;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private int condition;
    private boolean available;
    private long returnDate;  // date is stored in the unix epoch. seconds from midnight January 1 1970
    public Book() {
    }

    public Book(int bookId, String title, String author, int condition, boolean available, long returnDate) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.condition = condition;
        this.available = available;
        this.returnDate = returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(long returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", condition=" + condition +
                ", available=" + available +
                ", returnDate=" + returnDate +
                '}';
    }

}