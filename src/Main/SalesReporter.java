package Main;

import formatters.ReportFormatter;
import input.CsvSalesReader;
import model.Product;
import operations.SalesAnalyzer;
import output.ConsoleOutputStrategy;
import output.FileOutputStrategy;

import java.util.List;


public class SalesReporter {
    public static void main(String[] args) {
        // Validate command-line arguments
        if (args.length < 2) {
            System.err.println("Usage: java SalesReporter <csv-file-path> <output-method> [output-file-path]");
            System.exit(1);
        }

        String csvFilePath = args[0];
        String outputMethod = args[1];
        String outputFilePath = (args.length > 2) ? args[2] : null;


        // 1. Read Data
        CsvSalesReader reader = new CsvSalesReader();
        List<Product> products = reader.readData(csvFilePath);

        // 2. Analyze Data
        SalesAnalyzer analyzer = new SalesAnalyzer(products);

        // 3. Format Report
        String reportContent = ReportFormatter.generateReport(products, analyzer);

        // 4. Output Data using Factory
        if (outputMethod.equalsIgnoreCase("console")) {
            ConsoleOutputStrategy strateg = new ConsoleOutputStrategy() ;
            strateg.output(reportContent, outputFilePath);

        } else if (outputMethod.equalsIgnoreCase("file")) {
            FileOutputStrategy strateg = new FileOutputStrategy();
            strateg.output(reportContent, outputFilePath);

        }

    }
}
