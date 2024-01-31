package softeer.p6268;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void getBinaryOnCountByString() {
        assertThat(Main.getBinaryOnCount("10110101")).isEqualTo(5);
    }

    @Test
    void getBinaryOnCountByInteger() {
        assertThat(Main.getBinaryOnCount(5)).isEqualTo(2);
    }

    @Test
    void diffN1() {
        assertThat(Main.diffN(1, 4)).isEqualTo(2);
    }

    @Test
    void diffN2() {
        assertThat(Main.diffN(null, 2)).isEqualTo(5);
        assertThat(Main.diffN(9, null)).isEqualTo(6);
        assertThat(Main.diffN(null, null)).isEqualTo(0);
    }

    @Test
    void stringToArray() {
        assertThat(Main.stringToArray("1")).isEqualTo(new Integer[]{null, null, null, null, 1});
        assertThat(Main.stringToArray("34")).isEqualTo(new Integer[]{null, null, null, 3, 4});
        assertThat(Main.stringToArray("987")).isEqualTo(new Integer[]{null, null, 9, 8, 7});
    }

    @Nested
    class ExampleTestBlock {

        private ByteArrayOutputStream outputStream;

        @BeforeEach
        void setUp() {
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        void example1() throws IOException {
            String[] args = {
                    "2",
                    "1 2",
                    "9881 10724",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("5\n11\n");
        }

        @Test
        void example2() throws IOException {
            String[] args = {
                    "2",
                    "111 11",
                    "11 11111",
            };
            System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
            Main.main();
            assertThat(outputStream.toString()).isEqualTo("2\n6\n");
        }
    }
}