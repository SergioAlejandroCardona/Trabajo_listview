package com.example.listviewexample.Models;

public class Car {

    private String Name;
    private String CC;
    private String Model;
    private String Value;
    private String Url;

    public Car(){}

    public Car(String name, String CC, String model, String value, String url) {
        Name = name;
        this.CC = CC;
        Model = model;
        Value = value;
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
