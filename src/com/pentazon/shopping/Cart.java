package com.pentazon.shopping;

import com.pentazon.customers.Address;
import com.pentazon.exceptions.ProductExceptions;
import com.pentazon.payment.PaymentCard;
import com.pentazon.product.Product;
import com.pentazon.product.ProductService;
import com.pentazon.product.ProductServiceImpl;

import java.math.BigDecimal;
//import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class Cart {

    private Logger logger = Logger.getLogger(Cart.class.getName());
    private Map<String, Item> items;
    private ProductService productService;
    private BigDecimal total =BigDecimal.ZERO;
    private PaymentCard paymentCard;
    private Address Address;


    public Cart(){
        items = new HashMap<>();
        productService = new ProductServiceImpl();

    }

    public void addToCart(Product product, int quantity){
        if (verifiedProduct(product)){
            Item item = items.get(product.getProductId());
            if (item == null) {
                item = new Item(product);
            }

            item.addItems(BigDecimal.ONE.intValue());
            items.put(product.getProductId(), item);
            }

            }


            private boolean verifiedProduct(Product product){
        boolean verified = false;
        if (product != null){
            try {
                Product verifiedProduct = productService.findProductById(product.getProductId());
                verified = true;
            } catch (ProductExceptions ex){
                //logger.log(System.Logger.Level.INFO, ex.message())
                //@todo add log message

            }
        }
        return verified;
    }

    public boolean removeFromCart(Product product){
        boolean removed = false;
        if (product != null){
            this.items.remove(product.getProductId());
            removed = true;
        }
        return removed;
    }

    public BigDecimal calculateTotal(){
        if(!items.isEmpty()){
            this.total = BigDecimal.ZERO;
            Iterator<Item> cartItem = items.values().iterator();
            while(cartItem.hasNext()){
                this.total = this.total.add(cartItem.next().getTotal());
            }
        }
        return this.getTotal();
    }


    public  Map<String, Item> getItems() {
        return items;
    }

    public void setItems( Map<String, Item> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }


    public Address getDeliveryAddress() {
        return Address;
    }
}
