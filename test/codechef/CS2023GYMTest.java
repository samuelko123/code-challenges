package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CS2023GYMTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "2",
                "5 12",
                "4 5"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        CS2023GYM.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "7",
                        "3"
                )
        );
    }
}