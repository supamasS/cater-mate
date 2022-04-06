package com.perscholas.catermate.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CART")
public class Cart {
    @Transient
    private static final double SALES_TAX = 0.08;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long user_id;

    @Transient
    private double subTotal;

    @Transient
    private double tax;

    @Transient
    private double total;

    @OneToMany(targetEntity = CartItem.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<CartItem> cartItemList;

    public Cart() {
        user_id = 2;
        cartItemList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public double getSubTotal() {
        subTotal = 0.0d;
        cartItemList.forEach(i -> subTotal += i.getSubTotal());

        return subTotal;
    }

    public String getSubTotalDisplay() {
        return String.format("$%.2f", getSubTotal());
    }

//    public void setSubTotal(double subTotal) {
//        this.subTotal = subTotal;
//    }

    public double getTax() {
        return getSubTotal() * SALES_TAX;
    }

    public String getTaxDisplay() {
        return String.format("$%.2f", getTax());
    }

//    public void setTax(double tax) {
//        this.tax = tax;
//    }

    public double getTotal() {
        return getSubTotal() + getTax();
    }

    public String getTotalDisplay() {
        return String.format("$%.2f", getTotal());
    }

//    public void setTotal(double total) {
//        this.total = total;
//    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public void addCartItemToCart(CartItem cartItem) {
        this.cartItemList.add(cartItem);
//        this.subTotal += cartItem.getSubtotal();
//        this.tax = this.subTotal * SALES_TAX;
//        this.total = this.subTotal + this.tax;
//
//        System.out.println("subtotal is " + this.subTotal);
//        System.out.println("tax is " + this.tax);
//        System.out.println("total is " + this.total);
    }
}
