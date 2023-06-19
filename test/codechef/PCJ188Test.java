package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class PCJ188Test {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "2",
                "3",
                "8"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        PCJ188.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "10",
                        "120"
                )
        );
    }

    @Test
    void testSpeed() {
        var startTime = Instant.now();
        PCJ188.handleTestCase(1000);
        var endTime = Instant.now();

        assertThat(startTime.until(endTime, ChronoUnit.MILLIS)).isLessThan(1000);
    }
}