package output;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class FileOutputStrategyTest {

    @TempDir
    Path tempDir;


    @Test
    void testOutputToFile() throws Exception {

        Path outputFile =
                tempDir.resolve("report.txt");

        FileOutputStrategy strategy =
                new FileOutputStrategy();

        String report = "Test Sales Report";

        strategy.output(
                report,
                outputFile.toString()
        );

        String fileContent =
                Files.readString(outputFile);

        assertEquals(report, fileContent);
    }


    @Test
    void testOutputWithNullFilePath() {

        FileOutputStrategy strategy =
                new FileOutputStrategy();

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> strategy.output(
                                "Test Report",
                                null
                        )
                );

        assertTrue(
                exception.getMessage()
                        .contains("File path is required")
        );
    }


    @Test
    void testOutputWithEmptyFilePath() {

        FileOutputStrategy strategy =
                new FileOutputStrategy();

        assertThrows(
                IllegalArgumentException.class,
                () -> strategy.output(
                        "Test Report",
                        ""
                )
        );
    }
}