package com.pentazon.shopping;

import com.pentazon.customers.Buyer;
import com.pentazon.exceptions.CheckOutException;

public class ShoppingServiceImpl implements ShoppingService{


    @Override
    public boolean checkOut(Buyer buyer) throws CheckOutException {
        if(buyer == null){
            throw  new CheckOutException("No buyer found at check out");
        }

        if (buyer.getCart() == null){
            throw new CheckOutException("No cart found at checkpoint");
        }

        if(buyer.getCart().getItems().isEmpty()){
            throw new CheckOutException(" cart is empty at check point");
        }

        if(buyer.getCart() == null || buyer.getCards().isEmpty()){
            throw new CheckOutException(" No payment confirmed");
        }
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

        if(buyer.getCart() == null || buyer.getCards().isEmpty()){
            throw new CheckOutException(" No payment confirmed");
        }
        return true;

    }

    }

