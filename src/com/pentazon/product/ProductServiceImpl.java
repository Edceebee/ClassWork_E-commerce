package com.pentazon.product;

import com.pentazon.exceptions.ProductExceptions;

public class ProductServiceImpl implements ProductService{
private  ProductRepoMock productRepo = new ProductRepoMock();

    @Override
    public Product findProductById(String productId) throws ProductExceptions {
        return productRepo.getProductById(productId);
    }
}
