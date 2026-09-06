package output;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleOutputStrategyTest {

    @Test
    void testOutputToConsole() {

        ConsoleOutputStrategy strategy =
                new ConsoleOutputStrategy();

        String report = "Test Sales Report";

        ByteArrayOutputStream outputStream =
                new ByteArrayOutputStream();

        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outputStream));

        strategy.output(report, null);

        System.setOut(originalOut);

        assertEquals(
                "Test Sales Report",
                outputStream.toString().trim()
        );
    }
}