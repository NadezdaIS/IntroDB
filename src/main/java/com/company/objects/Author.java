package com.company.objects;

public class Author {

    private int id;
    private int bookid;
    private String name;
    private int age;

    public Author() {
    }

    public Author(int id, int bookid, String name, int age) {
        this.id = id;
        this.bookid = bookid;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
