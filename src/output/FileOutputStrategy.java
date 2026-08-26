package output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStrategy {

    public void output(String reportContent, String filePath) throws IOException {
        if (filePath == null || filePath.isEmpty());
        FileWriter writer = new FileWriter(filePath);
        System.out.println("Report successfully saved to " + filePath);
    }
}
