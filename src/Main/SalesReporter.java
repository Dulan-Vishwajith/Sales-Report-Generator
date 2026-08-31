package Main;

import cli.CommandLineArguments;
import formatters.ReportFormatter;
import input.CsvSalesReader;
import input.SalesReader;
import model.Product;
import operations.SalesAnalyzer;
import output.OutputStrategy;
import output.OutputStrategyFactory;

import java.util.List;


public class SalesReporter {

    public static void main(String[] args) {

        CommandLineArguments arguments = CommandLineArguments.parseArg(args);

        try{
            // 1. Read Data
            SalesReader reader = new CsvSalesReader();
            List<Product> products = reader.readData(arguments.getCsvFilePath());

            // 2. Analyze Data
            SalesAnalyzer analyzer = new SalesAnalyzer(products);

            // 3. Format Report
            String report = ReportFormatter.generateReport(products, analyzer);

            // 4. Output Data using Factory
            OutputStrategy strategy = OutputStrategyFactory.getStrategy(arguments.getOutputMethod());

            strategy.output(report,arguments.getOutputFilePath());

        } catch (Exception e){
            System.err.println("Error generating report: " + e.getMessage());
            System.exit(1);
        }
    }
}
