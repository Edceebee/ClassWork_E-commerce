package com.pentazon.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoMock {

    private List<Product> mockProducts;
    public ProductRepoMock(){
        mockProducts = new ArrayList<>();
        Product plantainChips = new Product("Adunni Chips", "Savory plantain chips", new BigDecimal(50));
        plantainChips.setProductId("AD001");
        mockProducts.add(plantainChips);

        Product noseMask = new Product();
        noseMask.setProductId("AD002");
        noseMask.setName("Bomu e nose mask");
        noseMask.setDescription("best in class nose mask");
        noseMask.setPrice(new BigDecimal(4500));
        mockProducts.add(noseMask);

        Product shirt = new Product();
        shirt.setProductId("AD003");
        mockProducts.add(shirt);
    }

    public List<Product> getMockProducts() {
        return mockProducts;
    }

    public void setMockProducts(List<Product> mockProducts) {
        this.mockProducts = mockProducts;
    }
    public Product getProductById(String Id){
        Product result = null;
        return result;
    }
}
