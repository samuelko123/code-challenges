package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CPLAYTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "10100101111011111111",
                "00000000000000000000",
                "01011101110110101111"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        CPLAY.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "TEAM-A 12",
                        "TIE",
                        "TEAM-B 7"
                )
        );
    }
}