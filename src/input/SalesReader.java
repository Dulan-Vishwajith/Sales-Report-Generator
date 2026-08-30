package input;

import model.Product;

import java.util.List;

public interface SalesReader {
    List<Product> readData(String filePath) throws Exception;
}
