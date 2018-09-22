package com.lab3.poly.lab3.model;

public class MyContact {
    String name,sdt;
    int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public MyContact(String name, String sdt) {
        this.name = name;
        this.sdt = sdt;
    }

    public MyContact(String name, String sdt, int img) {
        this.name = name;
        this.sdt = sdt;
        this.img = img;
    }

    public MyContact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
