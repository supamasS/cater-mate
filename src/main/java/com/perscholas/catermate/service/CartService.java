package com.perscholas.catermate.service;

import com.perscholas.catermate.model.Cart;
import com.perscholas.catermate.model.CartItem;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    void saveCart(Cart cart);
    Cart getCartById(long id);
    void deleteCartById(long id);
}
