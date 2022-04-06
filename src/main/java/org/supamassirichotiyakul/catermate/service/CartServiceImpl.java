package org.supamassirichotiyakul.catermate.service;

import org.supamassirichotiyakul.catermate.exception.CartNotFoundException;
import org.supamassirichotiyakul.catermate.model.Cart;
import org.supamassirichotiyakul.catermate.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(long id) {
        Cart cart = cartRepository.getById(id);
        if(cart == null) {
            throw new CartNotFoundException();
        }
        return cart;
    }

    @Override
    public void deleteCartById(long id) {
        cartRepository.deleteById(id);
    }
}
