package br.edu.cesmac.shoppingcart;

import org.junit.Test;
import static org.junit.Assert.*;

public class WishListTest {

    @Test
    public void canAddProducts() {
        WishList wishList = new WishList(new Customer(-9, "Erivan"));
        wishList.addProduct(new Product("TV", 100, new Brand("Marca")));
    }
    
    @Test
    public void canRemoteProducts() {
        WishList wishList = new WishList(new Customer(-9, "Erivan"));
        Product product = new Product("TV", 100, new Brand("Marca"));
        wishList.addProduct(product);
        wishList.removeProduct(product);
        
        assertEquals(0, wishList.getProductsCount());
    }
}
