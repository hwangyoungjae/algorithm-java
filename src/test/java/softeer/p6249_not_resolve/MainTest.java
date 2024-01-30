package softeer.p6249_not_resolve;

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
        System.setIn(new ByteArrayInputStream(String.join("\n", new String[]{
                "4 5",
                "a..tt",
                "gc...",
                "a.g.t",
                "a.g.t",
                ".c.ag",
        }).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("2\n");
    }

    @Test
    void example2() throws IOException {
        System.setIn(new ByteArrayInputStream(String.join("\n", new String[]{
                "4 1",
                "a",
                "g",
                "c",
                "t",
        }).getBytes()));

        Main.main();
        assertThat(outputStream.toString()).isEqualTo("4\n");
    }

    @Test
    void example3() throws IOException {
        System.setIn(new ByteArrayInputStream(String.join("\n", new String[]{
                "4 4",
                "a...",
                ".c..",
                "..g.",
                "...t",
        }).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("1\n");
    }
}