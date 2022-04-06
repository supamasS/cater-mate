package com.perscholas.catermate.model;


import javax.persistence.*;

@Entity
@Table(name="MENU_ITEMS")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    public MenuItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceDisplay() {
        return String.format("$%.2f", price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
