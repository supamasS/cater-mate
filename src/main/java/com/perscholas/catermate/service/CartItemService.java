package com.perscholas.catermate.service;

import com.perscholas.catermate.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();
    void saveCartItem(CartItem cartItem);
    CartItem getCartItemById(long id);
    void deleteCartItemById(long id);
}
