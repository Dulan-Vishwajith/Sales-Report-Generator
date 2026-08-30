package output;

public interface OutputStrategy {
    void output(String reportContent, String filePath) throws Exception;
}
