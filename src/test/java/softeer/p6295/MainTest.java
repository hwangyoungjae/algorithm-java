package softeer.p6295;

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
                "1 1",
                "2 3",
                "3 4",
                "9 8",
                "5 2",
        };
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
        Main.main();

        String expected = String.join("\n", new String[]{
                "Case #1: 2",
                "Case #2: 5",
                "Case #3: 7",
                "Case #4: 17",
                "Case #5: 7",
        }) + "\n";
        assertThat(outputStream.toString()).isEqualTo(expected);
    }
}