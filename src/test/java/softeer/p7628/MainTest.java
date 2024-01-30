package softeer.p7628;

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
        String[] args = {"6", "2 4 6 9 12 18"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("5\n");
    }

    @Test
    void example2() throws IOException {
        String[] args = {"5", "2 3 5 7 11"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("1\n");
    }
}