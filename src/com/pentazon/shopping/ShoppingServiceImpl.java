package com.pentazon.shopping;

import com.pentazon.customers.Buyer;
import com.pentazon.exceptions.CheckOutException;
import com.pentazon.payment.PayStack;
import com.pentazon.payment.PaymentService;

import java.time.LocalDate;

public class ShoppingServiceImpl implements ShoppingService{

    private PaymentService paymentService;

    public ShoppingServiceImpl()  {
        paymentService = new PayStack();

    }

    @Override
    public Order checkOut(Buyer buyer) throws CheckOutException {
        this.isValidCheckOut(buyer);
        Order order = new Order();
        Cart buyerCart = buyer.getCart();
        boolean result = paymentService.pay(buyer.getCart().getPaymentCard(), buyerCart.getTotal());

        if (result){
        order.setOrderItem(buyer.getCart().getItems());
        order.setPaid(result);
        order.setOrderDate(LocalDate.now());
        order.setOrderTotal(buyerCart.getTotal());
        order.setDeliveryAddress(order.getDeliveryAddress());
        buyer.setCart(null);

        return false;
    }



    private boolean isValidCheckOut(Buyer buyer) throws CheckOutException{
        if(buyer == null){
            throw  new CheckOutException("No buyer found at check out");
        }

        if (buyer.getCart() == null){
            throw new CheckOutException("No cart found at checkpoint");
        }

        if(buyer.getCart().getItems().isEmpty()){
            throw new CheckOutException(" cart is empty at check point");
        }

        if(buyer.getCart() == null){
            throw new CheckOutException(" No payment card found");
        }
        return true;

    }

    }

