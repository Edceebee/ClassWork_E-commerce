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
        assertTrue(cart.getProducts().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips);
        assertFalse(cart.getProducts().isEmpty());
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void removeCart(){
        assertTrue(cart.getProducts().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips);
        assertFalse(cart.getProducts().isEmpty());
        assertEquals(1, cart.getProducts().size());

        boolean result = cart.removeFromCart(plantainChips);
        assertTrue(result);
        assertTrue(cart.getProducts().isEmpty());
    }
}