package softeer.p7353;

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
        String[] args = {"2", "1 -1"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("-1\n");
    }

    @Test
    void example2() throws IOException {
        String[] args = {"2", "-1 -1"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("1\n");
    }

    @Test
    void example3() throws IOException {
        String[] args = {"3", "5 -1 4"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("20\n");
    }

    @Test
    void example4() throws IOException {
        String[] args = {"3", "-5 1 -4"};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("20\n");
    }
}