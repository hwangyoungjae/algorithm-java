package softeer.p7695;

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
        String[] args = {"4", "10 5", "6 -3", "3 2", "4 2"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("6 -3\n");
    }

    @Test
    void example2() throws IOException {
        String[] args = {"1", "1000 -1000"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("1000 -1000\n");
    }
}