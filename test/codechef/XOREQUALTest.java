package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class XOREQUALTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "5",
                "1",
                "2",
                "3",
                "4",
                "5"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        XOREQUAL.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "1",
                        "2",
                        "4",
                        "8",
                        "16"
                )
        );
    }
}