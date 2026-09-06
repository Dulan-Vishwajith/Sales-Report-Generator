package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testProductValues() {

        Product product = new Product(
                "P001",
                "Laptop",
                "Electronics",
                5,
                1000.0
        );

        assertEquals("P001", product.getId());
        assertEquals("Laptop", product.getName());
        assertEquals("Electronics", product.getCategory());
        assertEquals(5, product.getQuantitySold());
    }

    @Test
    void testRevenueCalculation() {

        Product product = new Product(
                "P001",
                "Laptop",
                "Electronics",
                5,
                1000.0
        );

        assertEquals(
                5000.0,
                product.getRevenue()
        );
    }
}