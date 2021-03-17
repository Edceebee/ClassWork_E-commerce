package com.pentazon.shopping;

import com.pentazon.customers.Address;
import com.pentazon.customers.Buyer;
import com.pentazon.customers.Customer;
import com.pentazon.exceptions.CheckOutException;
import com.pentazon.payment.PaymentCard;
import com.pentazon.product.Product;
import com.pentazon.product.ProductDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingServiceImplTest {

   private Buyer dozie;
   private ShoppingService shoppingService;

   @BeforeEach
    void setUp() throws CheckOutException {
       shoppingService = new ShoppingServiceImpl();

      ProductDB products = new ProductDB();

       dozie= new Buyer();
       PaymentCard fbnVisa = new PaymentCard("123455", "Don Dozie", LocalDate.of(2025, 07, 21));
       dozie.getCards().add(fbnVisa);
       Cart dozieCart = new Cart();

       dozieCart.addToCart(products.getMockProducts().get("ADDO1"), 5);

        dozieCart.setPaymentCard(dozie.getCards().get(0));
       Address home = new Address();
       home.setHouseNumber(19);
       home.setStreet("Aso rock Avenue");
       home.setCity("Aso Rock");
       dozie.getAddresses()
       dozie.setCart(dozieCart);
   }

   @Test
   void checkOutWithNullBuyer(){
      assertThrows(CheckOutException.class, () -> shoppingService.checkOut(null));
   }

    @Test
    void checkOutWithNullCart(){
       dozie.setCart(null);
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));
    }

    @Test
    void checkOutWithEmptyMessage(){
        dozie.setCart(new Cart());
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));
   }

    @Test
    void checkOutWithNullPaymentCard(){
        dozie.setCards(null);
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));
    }

    @Test
    void checkOutWithNoPaymentCard(){
        dozie.setCards(Collections.EMPTY_LIST);
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(dozie));
    }

    @Test
    void checkOut() {

        try {
            Map<String, Item> cartItems = dozie.getCart().getItems();
            Order dozieOrder = shoppingService.checkOut(dozie);
            assertNotNull(dozieOrder);
            assertEquals(cartItems, dozieOrder.getOrderItem());
            assertTrue(dozieOrder.isPaid());
            } catch (CheckOutException e) {
            e.printStackTrace();
        }
        }

    @Test
    void checkOutWithExpiredPaymentCard() {

        try {
            Map<String, Item> cartItems = dozie.getCart().getItems();
            Address deliveryAddress = dozie.getCart().getDeliveryAddress();
            Order dozieOrder = shoppingService.checkOut(dozie);
            assertNotNull(dozieOrder);
            assertEquals(cartItems, dozieOrder.getOrderItem());
            assertTrue(dozieOrder.isPaid());
        } catch (CheckOutException e) {
            e.printStackTrace();
        }
    }





}

