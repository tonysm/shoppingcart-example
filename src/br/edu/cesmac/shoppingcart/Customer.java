package br.edu.cesmac.shoppingcart;

class Customer {
    private int customerID;
    private String name;
    
    Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public int getId() {
        return customerID;
    }
}
