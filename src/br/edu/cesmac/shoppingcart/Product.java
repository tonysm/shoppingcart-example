package br.edu.cesmac.shoppingcart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesmac
 */
class Product {
    
    private String name;
    private double price;
    private Brand brand;
    private boolean isStar;

    public Product(String name, double price, Brand brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        
        this.isStar = false;
    }
    
    public Product(String name, double price, Brand brand, boolean isStar) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.isStar = isStar;
    }

    public double getPrice() {
        if (this.isStar) {
            return price * .9;
        }
        
        return price;
    }

    public String getName() {
        return name;
    }
    
    public String getBrandName() {
        return brand.getName();
    }

    public void changePrice(int price) throws InvalidProductPriceChangeException {
        if (invalidPrice(price)) {
            throw new InvalidProductPriceChangeException();
        }
        
        this.price = price;
    }

    private boolean invalidPrice(int price) {
        return price <= this.price * 0.6;
    }

    public boolean isStar() {
        return this.isStar;
    }
    
}
