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

class CS2023STKTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "3",
                "6",
                "1 7 3 0 2 13",
                "0 2 3 4 5 0",
                "3",
                "1 3 4",
                "3 1 2",
                "5",
                "1 2 3 0 1",
                "1 2 0 2 3"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        CS2023STK.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "ADDY",
                        "DRAW",
                        "OM"
                )
        );
    }

    @Test
    void testSpeed() {
        var rand = new Random();

        var arr1 = Arrays.stream((new Integer[100000]))
                .map((x) -> Math.abs(rand.nextInt()))
                .collect(Collectors.toList());

        var arr2 = Arrays.stream((new Integer[100000]))
                .map((x) -> Math.abs(rand.nextInt()))
                .collect(Collectors.toList());

        var startTime = Instant.now();
        CS2023STK.handleTestCase(arr1, arr2);
        var endTime = Instant.now();

        assertThat(startTime.until(endTime, ChronoUnit.MILLIS)).isLessThan(1000);
    }
}