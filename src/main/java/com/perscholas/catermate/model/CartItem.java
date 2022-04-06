package com.perscholas.catermate.model;


import javax.persistence.*;

@Entity
@Table(name="CART_ITEMS")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne(targetEntity = Cart.class, fetch = FetchType.EAGER)
////    private long cartId;
//    private Cart cart;

    private long menuItemId;

    private String name;

    private double price;

    private int quantity;

    @Transient
    private double subTotal;

    public CartItem() {
    }

    public CartItem(MenuItem menuItem) {
        this.menuItemId = menuItem.getId();
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
//        this.quantity = menuItem.getQuantity();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public long getCartId() {
//        return cartId;
//    }
//
//    public void setCartId(long cartId) {
//        this.cartId = cartId;
//    }


//    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }

    public long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(long menuItemId) {
        this.menuItemId = menuItemId;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return this.quantity*this.price;
    }

    public String getSubTotalDisplay() {
        return String.format("$%.2f", getSubTotal());
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
