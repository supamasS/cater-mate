package org.supamassirichotiyakul.catermate.service;

import org.supamassirichotiyakul.catermate.model.CartItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();
    void saveCartItem(CartItem cartItem);
    CartItem getCartItemById(long id);
    void deleteCartItemById(long id);
}
