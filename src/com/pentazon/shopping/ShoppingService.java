package com.pentazon.shopping;

import com.pentazon.customers.Buyer;
import com.pentazon.customers.Customer;
import com.pentazon.exceptions.CheckOutException;

public interface ShoppingService {

    public boolean checkOut(Buyer buyer) throws CheckOutException;

}
