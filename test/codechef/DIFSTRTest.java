package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class DIFSTRTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "2",
                "3",
                "101",
                "110",
                "100",
                "4",
                "1100",
                "1010",
                "0100",
                "0010"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        DIFSTR.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "000",
                        "0000"
                )
        );
    }
}