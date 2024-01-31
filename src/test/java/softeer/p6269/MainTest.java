package softeer.p6269;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    @Nested
    class ExampleTestBlock {
        private OutputStream outputStream;

        @BeforeEach
        void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        void example1() throws IOException {
            String[] args = {
                    "3 10 5",
                    "1 4 5",
                    "3 3 1 2 4 1 4 5 1 4",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("secret\n");
        }

        @Test
        void example2() throws IOException {
            String[] args = {
                    "4 10 3",
                    "2 1 3 2",
                    "1 3 2 1 3 2 1 3 2 1",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("secret\n");
        }

        @Test
        void example3() throws IOException {
            String[] args = {
                    "4 10 9",
                    "2 7 1 8",
                    "3 1 4 1 5 9 2 6 5 3",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("normal\n");
        }

        @Test
        void example4() throws IOException {
            String[] args = {
                    "4 3 5",
                    "1 2 3 4",
                    "3 2 1",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("normal\n");
        }
    }
}