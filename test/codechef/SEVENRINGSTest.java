package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class SEVENRINGSTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "4",
                "25 785",
                "402 11",
                "100 100",
                "333 333"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        SEVENRINGS.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "YES",
                        "NO",
                        "YES",
                        "NO"
                )
        );
    }
}