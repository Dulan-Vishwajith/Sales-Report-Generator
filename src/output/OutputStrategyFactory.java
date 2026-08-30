package output;

public class OutputStrategyFactory {
    public static OutputStrategy getStrategy(String method) {
        if (method.equalsIgnoreCase("console")) {
            return new ConsoleOutputStrategy();
        } else if (method.equalsIgnoreCase("file")) {
            return new FileOutputStrategy();
        }
         return null;
    }
}
