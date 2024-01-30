package softeer.p7626;

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
                "5",
                "1 3 5 8 10",
        };
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("3\n");
    }

    @Test
    void example2() throws IOException {
        String[] args = {
                "5",
                "1 3 5 7 8",
        };
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("1\n");
    }
}