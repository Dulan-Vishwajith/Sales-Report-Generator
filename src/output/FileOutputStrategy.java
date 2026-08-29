package output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStrategy {

    public void output(String reportContent, String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path is required for file output method.");
        }
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(reportContent);
        }
        System.out.println("Report successfully saved to " + filePath);
    }
}
