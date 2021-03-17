package com.pentazon.product;

import com.pentazon.exceptions.ProductExceptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {
    ProductService productService;
    Product product;
    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl();
        product = new Product();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findProduct(){

        Product product = null;
        try {
            product = productService.findProductById("Ad001");
        } catch (ProductExceptions e){
            e.printStackTrace();
        }
        assertNotNull(product);
    }


    @Test
    void findProductWithInvalidId() {
    assertThrows(ProductExceptions.class, () -> productService.findProductById("AA000"));

    }

    @Test
    void addProductWithName(){
        product.setName(null);
        assertThrows(ProductExceptions.class,
                () -> productService.addProduct(product));
    }


}
