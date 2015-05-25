package br.edu.cesmac.shoppingcart;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    Product product;
    
    @Before
    public void setUp() {
        product = new Product("TV", 60, new Brand("Marca"));
    }
    
    @Test
    public void productHasPrice() {
        assertEquals(60, product.getPrice(), 0.001);
    }
    
    @Test
    public void productHasName() {
        assertEquals("TV", product.getName());
    }
    
    @Test
    public void productCanHaveBrand() {
        assertEquals("Marca", product.getBrandName());
    }
    
    @Test
    public void canChangeProductPrice() throws InvalidProductPriceChangeException {
        product.changePrice(90);
        
        assertEquals(90, product.getPrice(), .001);
    }
    
    @Test
    public void cannotChangeProductIfTheDifferenceIsGreaterThan60PercentOfOldPrice() {
        try {
            product.changePrice(1);
            fail("Could change product price with invalid price");
        } catch (InvalidProductPriceChangeException ex) {
            
        }
    }
    
    @Test
    public void productCanBeStar() {
        Product staredProduct = new Product("TV", 60, new Brand("Marca"), true);
        
        assertTrue(staredProduct.isStar());
    }
    
    @Test
    public void starProductsHave10PercentDiscount() {
        Product staredProduct = new Product("TV", 60, new Brand("Marca"), true);
        assertEquals(54, staredProduct.getPrice(), 0.001);
    }
}
