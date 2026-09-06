package formatters;

import model.Product;
import operations.SalesAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReportFormatterTest {

    @Test
    void testGenerateReport() {

        List<Product> products = Arrays.asList(
                new Product("P001", "Laptop", "Electronics", 2, 1000.0),
                new Product("P002", "Mouse", "Electronics", 10, 20.0),
                new Product("P003", "Chair", "Furniture", 3, 100.0)
        );

        SalesAnalyzer analyzer = new SalesAnalyzer(products);

        String report =
                ReportFormatter.generateReport(products, analyzer);

        // Check report title
        assertTrue(report.contains(
                "PRODUCT SALES SUMMARY REPORT"
        ));

        // Check product information
        assertTrue(report.contains("Laptop"));
        assertTrue(report.contains("Mouse"));
        assertTrue(report.contains("Chair"));

        // Check categories
        assertTrue(report.contains("Electronics"));
        assertTrue(report.contains("Furniture"));

        // Check highlights
        assertTrue(report.contains(
                "Best-Selling Product"
        ));

        assertTrue(report.contains(
                "Highest Revenue"
        ));

        assertTrue(report.contains(
                "Grand Total Revenue"
        ));

        // Check calculated values
        assertTrue(report.contains("$2500.00"));
        assertTrue(report.contains("Mouse (10 units)"));
        assertTrue(report.contains("Laptop ($2000.00)"));
    }
}
