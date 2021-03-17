package com.pentazon.product;

import com.pentazon.exceptions.ProductExceptions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDB {

    private Map<String, Product> mockProducts;


    public ProductDB(){
        mockProducts = new HashMap<>();
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        mockProducts.put(plantainChips.getProductId(), plantainChips);

        Product noseMask = new Product();
        noseMask.setProductId("AD002");
        noseMask.setName("Bomu e nose mask");
        noseMask.setDescription("best in class nose mask");
        noseMask.setPrice(new BigDecimal(4500));
        mockProducts.put(noseMask.getProductId(), noseMask);

        Product shirt = new Product();
        shirt.setProductId("AD003");
        mockProducts.put(shirt.getProductId(), shirt);
    }

    public Map<String, Product> getMockProducts() {
        return mockProducts;
    }

    private void setMockProducts(Map<String, Product> mockProducts) {
        this.mockProducts = mockProducts;
    }
    public Product getProductById(String Id) throws ProductExceptions {
        Product result = mockProducts.get(Id);
        if (result == null){
            StringBuilder message = new StringBuilder("Product with Ids");
            message.append(Id);
            message.append("not found ");
            throw new ProductExceptions(message.toString());
        }

        return result;
    }
}
