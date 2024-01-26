package softeer.p6254;

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
                "10:00 19:00",
                "09:00 15:00",
                "10:00 11:00",
                "11:00 22:00",
                "09:00 15:00",
        }).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("1980" + "\n");
    }

    @Test
    void example2() throws IOException {
        System.setIn(new ByteArrayInputStream(String.join("\n", new String[]{
                "09:17 18:34",
                "09:17 18:34",
                "09:17 18:34",
                "09:17 18:34",
                "09:17 18:34",
        }).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("2785" + "\n");
    }

    @Test
    void example3() throws IOException {
        System.setIn(new ByteArrayInputStream(String.join("\n", new String[]{
                "09:17 19:24",
                "10:11 18:45",
                "09:34 18:27",
                "10:47 15:33",
                "08:47 18:32",
        }).getBytes()));
        Main.main();
        assertThat(outputStream.toString()).isEqualTo("2525" + "\n");
    }
}