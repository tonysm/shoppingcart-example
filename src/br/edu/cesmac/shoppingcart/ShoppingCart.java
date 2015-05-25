package br.edu.cesmac.shoppingcart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class ShoppingCart {

    private Customer customer;
    
    private Map<Product, Integer> productsList;
    
    public ShoppingCart(Customer customer) {
        this.customer = customer;
        productsList = new HashMap<Product, Integer>();
    }

    public void addProduct(Product product) throws InvalidProductQuantityException {
        this.addProduct(product, 1);
    }
    
    public void addProduct(Product product, int count) throws InvalidProductQuantityException {
        productsList.put(product, count);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        
        for (Entry<Product, Integer> item : productsList.entrySet()) {
            Product product = item.getKey();
            int count = item.getValue();
            
            totalPrice += product.getPrice() * count;
        }
        
        if (getProductsCount() >= 10) {
            return totalPrice * .9;
        }
        
        return totalPrice;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public void removeProduct(Product product)throws ProductNotFoundException {
    	for (Entry<Product, Integer> item : productsList.entrySet()) {
    		Product current = item.getKey();
    		
    		if (current.equals(product)) {
    			productsList.remove(current);
    			return;
    		}
    	}
        
        throw new ProductNotFoundException();
    }

    public int getProductsCount() {
        int totalProducts = 0;
        
        for (Entry<Product, Integer> item : productsList.entrySet()) {
            totalProducts += item.getValue();
        }
        
        return totalProducts;
    }
}
