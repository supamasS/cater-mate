package org.supamassirichotiyakul.catermate.service;

import org.supamassirichotiyakul.catermate.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    void saveCart(Cart cart);
    Cart getCartById(long id);
    void deleteCartById(long id);
}
