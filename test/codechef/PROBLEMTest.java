package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class PROBLEMTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "4",
                "4 2",
                "1 5",
                "2 3",
                "2 2"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        PROBLEM.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "YES",
                        "YES",
                        "NO",
                        "YES"
                )
        );
    }
}