package br.edu.cesmac.shoppingcart;

import java.util.ArrayList;
import java.util.List;

class WishList {
    private Customer customer;
    private List<Product> products;
    
    public WishList(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public int getProductsCount() {
        return products.size();
    }
}
