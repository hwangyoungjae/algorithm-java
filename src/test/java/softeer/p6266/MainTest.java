package softeer.p6266;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void example1() throws IOException {
        String[] args = {
                "3 7",
                "grandeur",
                "avante",
                "sonata",
                "sonata 14 16",
                "grandeur 11 12",
                "avante 15 18",
                "sonata 10 11",
                "avante 9 12",
                "grandeur 16 18",
                "avante 12 15",
        };
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        String[] expected = {
                "Room avante:",
                "Not available",
                "-----",
                "Room grandeur:",
                "2 available:",
                "09-11",
                "12-16",
                "-----",
                "Room sonata:",
                "3 available:",
                "09-10",
                "11-14",
                "16-18",
        };
        assertThat(outputStream.toString()).isEqualTo(String.join("\n", expected) + "\n");
    }

    @Test
    void example2() throws IOException {
        String[] args = {
                "3 2",
                "santafe",
                "aerocity",
                "porter",
                "santafe 9 12",
                "porter 9 18",
        };
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        String[] expected = {
                "Room aerocity:",
                "1 available:",
                "09-18",
                "-----",
                "Room porter:",
                "Not available",
                "-----",
                "Room santafe:",
                "1 available:",
                "12-18",
        };
        assertThat(outputStream.toString()).isEqualTo(String.join("\n", expected) + "\n");
    }
}