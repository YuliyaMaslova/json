package com.example;

public class MyObject {
    private int id;
    private String field;

    // Конструктор, геттеры и сеттеры
    public MyObject(int id, String field) {
        this.id = id;
        this.field = field;
    }

    public int getId() {
        return id;
    }

    public String getField() {
        return field;
    }
}
