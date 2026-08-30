package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Product;


public class CsvSalesReader implements SalesReader {

    @Override
    public List<Product> readData(String filePath) throws Exception {

        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 5) {
                    throw new IllegalArgumentException("Invalid row detected: missing columns.");
                }
                products.add(new Product(
                        values[0].trim(),
                        values[1].trim(),
                        values[2].trim(),
                        Integer.parseInt(values[3].trim()),
                        Double.parseDouble(values[4].trim())
                ));
            }
        }
        return products;
    }
}