package com.pentazon.customers;

import com.pentazon.payment.PaymentCard;
import com.pentazon.shopping.Cart;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Customer{

    private List<PaymentCard> cards;
    private Cart cart;

    public Buyer(){
        cards = new ArrayList<>();
    }

    public List<PaymentCard> getCards() {
        return cards;
    }

    public void setCards(List<PaymentCard> cards) {
        this.cards = cards;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
