package softeer.p6270;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    @Nested
    class ExampleTestBlock {
        OutputStream outputStream;

        @BeforeEach
        void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        void example1() throws IOException {
            String[] args = {
                    "3 3",
                    "50 50",
                    "40 40",
                    "10 30",
                    "60 76",
                    "18 28",
                    "22 50",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("36\n");
        }

        @Test
        void example2() throws IOException {
            String[] args = {
                    "3 3",
                    "50 90",
                    "10 90",
                    "40 50",
                    "50 40",
                    "10 100",
                    "40 40",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("10\n");
        }
    }
}