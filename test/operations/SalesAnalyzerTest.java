package operations;

import model.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SalesAnalyzerTest {

    @Test
    void testCategoryRevenues() {

        List<Product> products = Arrays.asList(
                new Product("P001", "Laptop", "Electronics", 2, 1000.0),
                new Product("P002", "Mouse", "Electronics", 5, 20.0),
                new Product("P003", "Chair", "Furniture", 3, 100.0)
        );

        SalesAnalyzer analyzer = new SalesAnalyzer(products);

        Map<String, Double> revenues =
                analyzer.getCategoryRevenues();

        assertEquals(2100.0,
                revenues.get("Electronics"));

        assertEquals(300.0,
                revenues.get("Furniture"));
    }


    @Test
    void testBestSellingProduct() {

        List<Product> products = Arrays.asList(
                new Product("P001", "Laptop", "Electronics", 2, 1000.0),
                new Product("P002", "Mouse", "Electronics", 10, 20.0),
                new Product("P003", "Chair", "Furniture", 3, 100.0)
        );

        SalesAnalyzer analyzer = new SalesAnalyzer(products);

        Product bestSeller =
                analyzer.getBestSellingProduct();

        assertEquals("Mouse", bestSeller.getName());
        assertEquals(10, bestSeller.getQuantitySold());
    }


    @Test
    void testHighestRevenueProduct() {

        List<Product> products = Arrays.asList(
                new Product("P001", "Laptop", "Electronics", 2, 1000.0),
                new Product("P002", "Mouse", "Electronics", 10, 20.0),
                new Product("P003", "Chair", "Furniture", 3, 100.0)
        );

        SalesAnalyzer analyzer = new SalesAnalyzer(products);

        Product highestRevenue =
                analyzer.getHighestRevenueProduct();

        assertEquals("Laptop",
                highestRevenue.getName());
    }


    @Test
    void testGrandTotal() {

        List<Product> products = Arrays.asList(
                new Product("P001", "Laptop", "Electronics", 2, 1000.0),
                new Product("P002", "Mouse", "Electronics", 5, 20.0),
                new Product("P003", "Chair", "Furniture", 3, 100.0)
        );

        SalesAnalyzer analyzer = new SalesAnalyzer(products);

        assertEquals(2400.0,
                analyzer.getGrandTotal());
    }
}