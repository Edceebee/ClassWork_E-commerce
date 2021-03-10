package com.pentazon.shopping;

import com.pentazon.product.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addToCart(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 9);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void removeCart(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 9);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(1, cart.getItems().size());

        boolean result = cart.removeFromCart(plantainChips);
        assertTrue(result);
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void  calculateTotal(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips, 9);

        Product shirt = new Product();
        shirt.setProductId("AD003");
        cart.addToCart(shirt, 9);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(2, cart.getItems().size());
        BigDecimal cartTotal = cart.calculateTotal();
        //assertEquals(5050, cartTotal.intValue());

        CartItem chipsItem = cart.getItems().get(plantainChips.getProductId());

        assertEquals(1, chipsItem.getQuantity());
        chipsItem = cart.getItems().get(shirt.getProductId());
        assertEquals(1, chipsItem.getQuantity());

        cart.addToCart(shirt, 9);
        assertEquals(2, cart.getItems().size());
        chipsItem = cart.getItems().get(shirt.getProductId());
        assertEquals(10, chipsItem.getQuantity());
        cartTotal = cart.calculateTotal();
        assertEquals(5500, cartTotal.intValue());


    }
}