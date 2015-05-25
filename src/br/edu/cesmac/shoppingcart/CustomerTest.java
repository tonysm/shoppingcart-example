package br.edu.cesmac.shoppingcart;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void customerHasAnID() {
        Customer customer = new Customer(-9, "Erivan");
        assertEquals(-9, customer.getId());
    }
}
