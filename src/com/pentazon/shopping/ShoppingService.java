package com.pentazon.shopping;

import com.pentazon.customers.Buyer;
import com.pentazon.exceptions.CheckOutException;

public interface ShoppingService {

    public Order checkOut(Buyer buyer) throws CheckOutException;

}
