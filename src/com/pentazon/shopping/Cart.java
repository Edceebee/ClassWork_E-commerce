package com.pentazon.shopping;

import com.pentazon.exceptions.ProductExceptions;
import com.pentazon.product.Product;
import com.pentazon.product.ProductRepoMock;
import com.pentazon.product.ProductService;
import com.pentazon.product.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Cart {

    private Logger logger = Logger.getLogger(Cart.class.getName());

    private List<Product> products;
    private ProductService productService;


    public Cart(){
        products = new ArrayList<>();
        productService = new ProductServiceImpl();

    }

    public void addToCart(Product product){
        if (verifiedProduct(product)){
//            Product verifiedProduct = productService.findProductById(product.getProductId());
            this.products.add(product);
        }

    }

    private boolean verifiedProduct(Product product){
        boolean verified = false;
        if (product != null){
            try {
                Product verifiedProduct = productService.findProductById(product.getProductId());
                verified = true;
            } catch (ProductExceptions ex){
                //logger.log(System.Logger.Level.INFO)
                //@todo add log message

            }
        }
        return verified;
    }

    public boolean removeFromCart(Product product){
        boolean removed = false;
        if (product != null){
            this.products.remove(product);
            removed = true;
        }
        return removed;
    }

    public List<Product> getProducts() {
        return products;
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }
}
