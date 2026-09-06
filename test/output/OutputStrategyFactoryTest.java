package output;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutputStrategyFactoryTest {

    @Test
    void testGetConsoleStrategy() {

        OutputStrategy strategy =
                OutputStrategyFactory.getStrategy("console");

        assertInstanceOf(
                ConsoleOutputStrategy.class,
                strategy
        );
    }


    @Test
    void testGetFileStrategy() {

        OutputStrategy strategy =
                OutputStrategyFactory.getStrategy("file");

        assertInstanceOf(
                FileOutputStrategy.class,
                strategy
        );
    }


    @Test
    void testCaseInsensitiveMethod() {

        OutputStrategy strategy =
                OutputStrategyFactory.getStrategy("CONSOLE");

        assertInstanceOf(
                ConsoleOutputStrategy.class,
                strategy
        );
    }


    @Test
    void testInvalidOutputMethod() {

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> OutputStrategyFactory.getStrategy("invalid")
                );

        assertTrue(
                exception.getMessage()
                        .contains("Invalid output method")
        );
    }
}