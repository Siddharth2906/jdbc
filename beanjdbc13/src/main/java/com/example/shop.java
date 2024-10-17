package com.example;

public class shop {
    int id, contact_no;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContact_no() {
        return contact_no;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public shop(int id, int contact_no, String name) {
        this.id = id;
        this.contact_no = contact_no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "shop [id=" + id + ", contact_no=" + contact_no + ", name=" + name + "]";
    }

}
