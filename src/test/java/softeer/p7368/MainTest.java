package softeer.p7368;

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
        String[] args = {"7 3 10"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("44\n");
    }

    @Test
    void example2() throws IOException {
        String[] args = {"10 3 10"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("50\n");
    }
}