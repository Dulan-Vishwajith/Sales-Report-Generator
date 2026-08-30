package Main;

import cli.CommandLineArguments;
import formatters.ReportFormatter;
import input.CsvSalesReader;
import input.SalesReader;
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

        //
        CommandLineArguments arguments = CommandLineArguments.parseArg(args);


        try{
            // 1. Read Data
            SalesReader reader = new CsvSalesReader();
            List<Product> products = reader.readData(arguments.getCsvFilePath());

            // 2. Analyze Data
            SalesAnalyzer analyzer = new SalesAnalyzer(products);

            // 3. Format Report
            String reportContent = ReportFormatter.generateReport(products, analyzer);

            // 4. Output Data using Factory
            if (arguments.getOutputMethod().equalsIgnoreCase("console")) {
                ConsoleOutputStrategy strateg = new ConsoleOutputStrategy() ;
                strateg.output(reportContent);

            } else if (arguments.getOutputMethod().equalsIgnoreCase("file")) {
                FileOutputStrategy strateg = new FileOutputStrategy();
                strateg.output(reportContent, arguments.getOutputFilePath());

            }

        } catch (Exception e){
            System.err.println("Error generating report: " + e.getMessage());
            System.exit(1);
        }
    }
}
