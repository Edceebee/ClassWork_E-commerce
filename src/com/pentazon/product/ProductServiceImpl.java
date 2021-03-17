package com.pentazon.product;

import com.pentazon.exceptions.ProductExceptions;

public class ProductServiceImpl implements ProductService{
private ProductDB productRepo = new ProductDB();

    @Override
    public Product findProductById(String productId) throws ProductExceptions {
        return productRepo.getProductById(productId);
    }
}
