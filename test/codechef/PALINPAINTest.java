package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class PALINPAINTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "2",
                "2 4",
                "3 3"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        PALINPAIN.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "abbbba",
                        "bbaabb",
                        "-1"
                )
        );
    }
}