package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class CS2023PONTest {
    @Test
    void testMain() {
        var stdin = "2\n6 5\n1 7 3 4 2 13\n3 2\n1 3 4";
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        CS2023PON.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"), "YES", "NO")
        );
    }

    @Test
    void testCase1() {
        var result = CS2023PON.handleTestCase(List.of(1, 7, 3, 4, 2, 13), 5);
        assertThat(result).isTrue();
    }

    @Test
    void testCase2() {
        var result = CS2023PON.handleTestCase(List.of(1, 3, 4), 2);
        assertThat(result).isFalse();
    }

    @Test
    void testSpeed() {
        var rand = new Random();
        var arr = Arrays.stream((new Integer[100000]))
                .map((x) -> Math.abs(rand.nextInt()))
                .collect(Collectors.toList());

        var startTime = Instant.now();
        CS2023PON.handleTestCase(arr, 2);
        var endTime = Instant.now();

        assertThat(startTime.until(endTime, ChronoUnit.MILLIS)).isLessThan(1000);
    }
}