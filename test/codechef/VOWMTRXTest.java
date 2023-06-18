package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class VOWMTRXTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "2",
                "3 1",
                "neo",
                "10 2",
                "babylonian"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        VOWMTRX.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "1",
                        "2"
                )
        );
    }

    @Test
    void testSpeed() {
        var rand = new Random();
        var chars = "abcdefghijklmnopqrstuvwxyz";

        var arr = Arrays.stream((new Integer[100000]))
                .map((x) -> chars.charAt(rand.nextInt(chars.length())))
                .collect(Collectors.toList());

        var startTime = Instant.now();
        VOWMTRX.handleTestCase(arr, 2);
        var endTime = Instant.now();

        assertThat(startTime.until(endTime, ChronoUnit.MILLIS)).isLessThan(1000);
    }
}