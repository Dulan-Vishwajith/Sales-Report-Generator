package operations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Product;

public class SalesAnalyzer {
    private List<Product> products;

    public SalesAnalyzer(List<Product> products) {
        this.products = products;
    }

    public Map<String, Double> getCategoryRevenues() {

        Map<String, Double> categoryRevenue = new HashMap<>();

        for (Product p : products) {

            String category = p.getCategory();
            double revenue = p.getRevenue();

            if (categoryRevenue.containsKey(category)) {
                double oldRevenue = categoryRevenue.get(category);
                categoryRevenue.put(category, oldRevenue + revenue);
            } else {
                categoryRevenue.put(category, revenue);
            }
        }

        return categoryRevenue;
    }

    public Product getBestSellingProduct() {
        Product best = null;
        for (Product p : products) {
            if (best == null || p.getQuantitySold() > best.getQuantitySold()) {
                best = p;
            }
        }
        return best;
    }

    public Product getHighestRevenueProduct() {
        Product highest = null;
        for (Product p : products) {
            if (highest == null || p.getRevenue() > highest.getRevenue()) {
                highest = p;
            }
        }
        return highest;
    }

    public double getGrandTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getRevenue();
        }
        return total;
    }
}
