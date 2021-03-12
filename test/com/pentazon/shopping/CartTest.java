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
        cart.addToCart(plantainChips);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void removeCart(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(1, cart.getItems().size());

        boolean result = cart.removeFromCart(plantainChips);
        assertTrue(result);
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void calculateTotal(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips);
        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(2, cart.getItems().size());
        BigDecimal cartTotal = cart.calculateTotal();
        assertEquals(5050, cartTotal.intValue());
    }

    @Test
    void calculateTotalWithMultipleChips(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips);
        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(2, cart.getItems().size());
        BigDecimal cartTotal = cart.calculateTotal();
        assertEquals(5050, cartTotal.intValue());

        CartItem chipsItem = cart.getItems().get(plantainChips.getProductId());
        assertEquals(1, chipsItem.getQuantity());

        CartItem shirtItem = cart.getItems().get(shirt.getProductId());
        assertEquals(1, shirtItem.getQuantity());

        cart.addToCart(plantainChips);
        assertEquals(2, cart.getItems().size());
        chipsItem = cart.getItems().get(plantainChips.getProductId());
        assertEquals(2, chipsItem.getQuantity());
        cartTotal = cart.calculateTotal();
        assertEquals(5100, cartTotal.intValue());
    }

    @Test
    void calculateTotalWithMultipleChipsAndShirts(){
        assertTrue(cart.getItems().isEmpty());
        Product plantainChips = new Product("Adunni Chips", "Savoury plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        cart.addToCart(plantainChips);
        Product shirt = new Product("Vintage Shirt", "Vintage Versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        cart.addToCart(shirt);
        assertFalse(cart.getItems().isEmpty());
        assertEquals(2, cart.getItems().size());
        BigDecimal cartTotal = cart.calculateTotal();
        assertEquals(5050, cartTotal.intValue());

        CartItem chipsItem = cart.getItems().get(plantainChips.getProductId());
        assertEquals(1, chipsItem.getQuantity());

        CartItem shirtItem = cart.getItems().get(shirt.getProductId());
        assertEquals(1, shirtItem.getQuantity());

        cart.addToCart(plantainChips);
        assertEquals(2, cart.getItems().size());
        chipsItem = cart.getItems().get(plantainChips.getProductId());
        assertEquals(2, chipsItem.getQuantity());
        cartTotal = cart.calculateTotal();
        assertEquals(5100, cartTotal.intValue());

        cart.addToCart(shirt);
        assertEquals(2, cart.getItems().size());
        shirtItem = cart.getItems().get(shirt.getProductId());
        assertEquals(2, shirtItem.getQuantity());
        cartTotal = cart.calculateTotal();
        assertEquals(10100, cartTotal.intValue());
    }
}