package com.churchill.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String year_published;
    private String available;
    private String borrower;

    //constructor
    public Book(String id,String title,String author,String genre,String year_published,String available,String borrower){
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year_published = year_published;
        this.available = available;
        this.borrower = borrower;
    }

    //getters
    public String getId() {return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public String getGenre() {return genre;}
    public String getYear_published() {return year_published;}
    public String getAvailable() {return available;}
    public String getBorrower() {return borrower;}

    //setters
    public void setId(String id) { this.id = id; }
    public void setTitle(String title){this.title = title;}
    public void setAuthor(String author){this.author = author;}
    public void setGenre(String genre){this.genre = genre;}
    public void setYear_published(String year_published){this.year_published = year_published;}
    public void setAvailable(String available){this.available = available;}
    public void setBorrower(String borrower){this.borrower = borrower;}
}
