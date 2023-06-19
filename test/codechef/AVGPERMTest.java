package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class AVGPERMTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "3",
                "4",
                "3",
                "6"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        AVGPERM.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "4 1 2 3",
                        "1 2 3",
                        "6 4 1 2 3 5"
                )
        );
    }

    @Test
    void testSpeed() {
        var startTime = Instant.now();
        AVGPERM.handleTestCase(100000);
        var endTime = Instant.now();

        assertThat(startTime.until(endTime, ChronoUnit.MILLIS)).isLessThan(1000);
    }
}