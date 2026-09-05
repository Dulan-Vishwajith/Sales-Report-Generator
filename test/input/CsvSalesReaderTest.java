package input;

import model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvSalesReaderTest {

    @TempDir
    Path tempDir;


    @Test
    void testReadValidCsvFile() throws Exception {

        Path csvFile = tempDir.resolve("sales.csv");

        String csvContent =
                "ID,Name,Category,Quantity,UnitPrice\n" +
                        "P001,Laptop,Electronics,2,1000.0\n" +
                        "P002,Mouse,Electronics,5,20.0\n";

        Files.writeString(csvFile, csvContent);

        CsvSalesReader reader = new CsvSalesReader();

        List<Product> products =
                reader.readData(csvFile.toString());

        assertEquals(2, products.size());

        assertEquals("P001",
                products.get(0).getId());

        assertEquals("Laptop",
                products.get(0).getName());

        assertEquals("Electronics",
                products.get(0).getCategory());

        assertEquals(2,
                products.get(0).getQuantitySold());

        assertEquals(2000.0,
                products.get(0).getRevenue());
    }


    @Test
    void testInvalidCsvRow() throws Exception {

        Path csvFile = tempDir.resolve("invalid.csv");

        String csvContent =
                "ID,Name,Category,Quantity,UnitPrice\n" +
                        "P001,Laptop,Electronics\n";

        Files.writeString(csvFile, csvContent);

        CsvSalesReader reader = new CsvSalesReader();

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> reader.readData(csvFile.toString())
                );

        assertTrue(
                exception.getMessage()
                        .contains("Invalid row detected")
        );
    }


    @Test
    void testEmptyCsvFileWithOnlyHeader() throws Exception {

        Path csvFile = tempDir.resolve("empty.csv");

        String csvContent =
                "ID,Name,Category,Quantity,UnitPrice\n";

        Files.writeString(csvFile, csvContent);

        CsvSalesReader reader = new CsvSalesReader();

        List<Product> products =
                reader.readData(csvFile.toString());

        assertTrue(products.isEmpty());
    }
}