package formatters;

import java.util.List;
import java.util.Map;
import model.Product;
import operations.SalesAnalyzer;

public class ReportFormatter {
    public static String generateReport(List<Product> products, SalesAnalyzer analyzer) {
        StringBuilder sb = new StringBuilder();
        sb.append("============================================\n");
        sb.append("        PRODUCT SALES SUMMARY REPORT        \n");
        sb.append("============================================\n\n");

        sb.append("--- Revenue Per Product ---\n");
        for (Product p : products) {
            sb.append(String.format("%s %-15s %-15s $%.2f\n",
                    p.getId(), p.getName(), p.getCategory(), p.getRevenue()));
        }

        sb.append("\n--- Revenue Per Category ---\n");
        for (Map.Entry<String, Double> entry : analyzer.getCategoryRevenues().entrySet()) {
            sb.append(String.format("%-15s : $%.2f\n", entry.getKey(), entry.getValue()));
        }

        Product bestSeller = analyzer.getBestSellingProduct();
        Product topRevenue = analyzer.getHighestRevenueProduct();

        sb.append("\n--- Highlights ---\n");
        sb.append(String.format("Best-Selling Product  : %s (%d units)\n",
                bestSeller.getName(), bestSeller.getQuantitySold()));
        sb.append(String.format("Highest Revenue       : %s ($%.2f)\n",
                topRevenue.getName(), topRevenue.getRevenue()));
        sb.append(String.format("Grand Total Revenue   : $%.2f\n", analyzer.getGrandTotal()));

        return sb.toString();
    }
}