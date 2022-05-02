package com.company.objects;

public class Author {

    private int id;
    private int bookid;
    private String name;
    private int age;

    public Author() {
    }



    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(int age) {
        this.age = age;
    }
}
