package softeer.p6280;

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
            System.setIn(new ByteArrayInputStream("1".getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("9\n");
        }

        @Test
        void example2() throws IOException {
            System.setIn(new ByteArrayInputStream("2".getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("25\n");
        }

        @Test
        void example3() throws IOException {
            System.setIn(new ByteArrayInputStream("3".getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("81\n");
        }

        @Test
        void example4() throws IOException {
            System.setIn(new ByteArrayInputStream("4".getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("289\n");
        }
    }
}