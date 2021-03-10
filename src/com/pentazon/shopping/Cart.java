package com.pentazon.shopping;

import com.pentazon.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;
    public Cart(){
        products = new ArrayList<>();
    }

    public void addToCart(Product product){

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
