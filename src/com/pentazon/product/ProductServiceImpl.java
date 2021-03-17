package com.pentazon.product;

import com.pentazon.exceptions.ProductExceptions;

public class ProductServiceImpl implements ProductService{
private ProductDB productRepo = new ProductDB();

    @Override
    public Product findProductById(String productId) throws ProductExceptions {
        return productRepo.getProductById(productId);
    }

    @Override
    public boolean addProduct(Product product) throws ProductExceptions {
        if(product == null){
            throw new ProductExceptions("Cannot adda a null product");

        }
        if(product.getName() == null || product.getName().equals(" ")){
            throw new ProductExceptions("Product name is required");
        }


        return false;
    }

    @Override
    public boolean removeProduct(Product product) throws ProductExceptions {
        return false;
    }
}
