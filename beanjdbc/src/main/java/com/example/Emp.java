package com.example;

public class Emp {

    int id;
    String name,country;
    public Emp(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
    public Emp() {
    }
    public int getId() {
        return id;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + ", country=" + country + "]";
    }

    
}
