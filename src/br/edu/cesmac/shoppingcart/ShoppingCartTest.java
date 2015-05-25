package br.edu.cesmac.shoppingcart;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {
    Customer customer;
    ShoppingCart shoppingCart;
    
    @Before
    public void setUp() {
        customer = new Customer(-9, "Erivan");
        shoppingCart = new ShoppingCart(customer);
    }
    
    private static Product buildProduct(String name, double price) {
        return buildProduct(name, price, null);
    }
    
    private static Product buildProduct(String name, double price, String brandName) {
        if (brandName == null) {
            brandName = "Marca";
        }
        
        return new Product(name, price, new Brand(brandName));
    }
    
    private static Product buildStarProduct(String name, double price) {
        return new Product(name, price, new Brand("Marca"), true);
    }
    
    @Test
    public void canAddProduct() throws InvalidProductQuantityException {
        shoppingCart.addProduct(buildProduct("TV", 800));
    }
    
    @Test
    public void canGetTotalPrice() throws InvalidProductQuantityException  {
        shoppingCart.addProduct(buildProduct("TV", 800));
        assertEquals(800, shoppingCart.getTotalPrice(), 0.001);
    }
    
    @Test
    public void canGetPricesOfMultipleProducts() throws InvalidProductQuantityException  {
        shoppingCart.addProduct(buildProduct("TV", 500));
        shoppingCart.addProduct(buildProduct("Fogão", 500));
        
        assertEquals(1000, shoppingCart.getTotalPrice(), .001);
    }
    
    @Test
    public void canAddMultipleProductsOfSameType() throws InvalidProductQuantityException {
        shoppingCart.addProduct(buildProduct("TV", 500), 2);
        
        assertEquals(1000, shoppingCart.getTotalPrice(), 0.001);
    }
    
    @Test
    public void canGetCustomerId() {
        assertEquals(customer.getId(), shoppingCart.getCustomerId());
    }
    
    @Test
    public void canRemoveProduct() throws InvalidProductQuantityException, ProductNotFoundException {
        shoppingCart.addProduct(buildProduct("TV", 600));
        Product product = buildProduct("TV", 200);
        shoppingCart.addProduct(product);
        
        shoppingCart.removeProduct(product);
        
        assertEquals(1, shoppingCart.getProductsCount());
    }
    
    @Test
    public void gives10PercentDiscountWhenMoreThan10Items() throws InvalidProductQuantityException {
        for (int i = 0; i < 10; i++) {
            shoppingCart.addProduct(buildProduct("TV", 600));
        }
        
        assertEquals(5400, shoppingCart.getTotalPrice(), .001);
    }
    
    @Test
    public void givesBothDiscountsWhenStarProductsAndMoreThan10Products() throws InvalidProductQuantityException {
        for (int i = 0; i < 10; i++) {
            shoppingCart.addProduct(buildStarProduct("TV", 600));
        }
        
        assertEquals(4860, shoppingCart.getTotalPrice(), .001);
    }
    
    @Test
    public void throwsExceptionWhenDoesNotFindProductToRemove() {
        try {
            shoppingCart.removeProduct(buildStarProduct("TV", 600));
            fail("did not throw an exception when removing a product that does not exist");
        } catch (ProductNotFoundException e) {
        }
    }
}
