package org.supamassirichotiyakul.catermate.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.supamassirichotiyakul.catermate.model.Cart;
import org.supamassirichotiyakul.catermate.model.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartServiceImplTest {
    @Autowired
    private CartService cartService;

    @Autowired
    private MenuItemService menuItemService;

    @DisplayName("Parameterized test using JUnit 5 assert")
    @ParameterizedTest(name = "add {1} menuItem with id {0} to cart")
    @CsvSource({
            " 1, 1",
            " 2, 1",
            "10, 4"
    })
    @Transactional
    void getAllCartsShouldReturnCorrectResultList(int menuItemId, int quantity) {
        // act and assert
        List<Cart> allCarts = cartService.getAllCarts();
        int beforeAddingMoreCarts = allCarts.size();

        Assertions.assertThat(beforeAddingMoreCarts).isEqualTo(0);

        Cart cart = new Cart();

        cart.setCurrentItemQuantity(quantity);

        cartService.addMenuItemToCartById(cart, menuItemId);
        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);

        double subTotal = quantity * menuItem.getPrice();

        Assertions.assertThat(cart.getSubTotal()).isEqualTo(subTotal);
        Assertions.assertThat(cart.getTax()).isEqualTo(subTotal * 0.08);
        Assertions.assertThat(cart.getTotal()).isEqualTo(subTotal + subTotal * 0.08);

        cartService.saveCart(cart);
        int afterAddingMoreCarts = cartService.getAllCarts().size();

        Assertions.assertThat(afterAddingMoreCarts).isEqualTo(beforeAddingMoreCarts + 1);
        Assertions.assertThat(allCarts.contains(cart));
    }
}
