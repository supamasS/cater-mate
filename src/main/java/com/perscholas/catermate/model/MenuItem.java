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

//    @Transient
//    private int quantity; // needed to keep initial quantity for cartItem, not really used by menuItem
//
//    @Transient
//    private String quantityString;

    public MenuItem() {
//        this.quantity = 2;
//        this.quantityString = "25";
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

//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//        this.quantityString = String.valueOf(quantity);
//    }
//
//    public String getQuantityString() {
//        return quantityString;
//    }
//
//    public void setQuantityString(String quantityString) {
//        this.quantityString = quantityString;
//        this.quantity = Integer.parseInt(quantityString);
//    }
}
