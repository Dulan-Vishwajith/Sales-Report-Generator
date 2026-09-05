package cli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandLineArgumentsTest {

    @Test
    void testParseArgumentsWithTwoArguments() {

        String[] args = {"data/sales.csv", "console"};

        CommandLineArguments result =
                CommandLineArguments.parseArg(args);

        assertEquals("data/sales.csv",
                result.getCsvFilePath());

        assertEquals("console",
                result.getOutputMethod());

        assertNull(result.getOutputFilePath());
    }


    @Test
    void testParseArgumentsWithThreeArguments() {

        String[] args = {
                "data/sales.csv",
                "file",
                "output/report.txt"
        };

        CommandLineArguments result =
                CommandLineArguments.parseArg(args);

        assertEquals("data/sales.csv",
                result.getCsvFilePath());

        assertEquals("file",
                result.getOutputMethod());

        assertEquals("output/report.txt",
                result.getOutputFilePath());
    }


    @Test
    void testParseArgumentsWithLessThanTwoArguments() {

        String[] args = {"data/sales.csv"};

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> CommandLineArguments.parseArg(args)
                );

        assertTrue(
                exception.getMessage().contains("Usage")
        );
    }
}