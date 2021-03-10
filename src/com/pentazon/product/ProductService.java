package com.pentazon.product;

import com.pentazon.exceptions.ProductExceptions;

/**
 *  provides services for dealing with product in pentazon
 */

public interface ProductService {

//    Product findProductById(String productId);
    /**
     * search for product
     */
    public Product findProductById(String productId) throws ProductExceptions;
//        return productRepo.getProductById(productId);
//    }

}
