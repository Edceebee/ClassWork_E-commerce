package com.pentazon.product;

import com.pentazon.exceptions.ProductExceptions;

/**
 *  provides services for dealing with product in pentazon
 */

public interface ProductService {


    /**
     * search for product with specified id
     * @param productId
     *  @return
     *  @throws ProductExceptions
     */
    public Product findProductById(String productId) throws ProductExceptions;
  }
