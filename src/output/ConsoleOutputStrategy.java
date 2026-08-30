package output;

public class ConsoleOutputStrategy implements OutputStrategy {
    @Override
    public void output(String reportContent, String filePath) {
        System.out.println(reportContent);
    }
}
