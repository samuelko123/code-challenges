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

class REMOSETTest {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "2",
                "3", "2 1 4",
                "3", "1 2 3"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        REMOSET.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "4",
                        "2"
                )
        );
    }

    @Test
    void testCase1() {
        var result = REMOSET.handleTestCase(List.of(2, 1, 4));
        assertThat(result).isEqualTo(4);
    }

    @Test
    void testCase2() {
        var result = REMOSET.handleTestCase(List.of(1, 2, 3));
        assertThat(result).isEqualTo(2);
    }

    @Test
    void testCase3() {
        var result = REMOSET.handleTestCase(List.of(1, 3, 5, 7, 9));
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testSpeed() {
        var rand = new Random();
        var arr = Arrays.stream((new Integer[100000]))
                .map((x) -> Math.abs(rand.nextInt()))
                .collect(Collectors.toList());

        var startTime = Instant.now();
        REMOSET.handleTestCase(arr);
        var endTime = Instant.now();


        assertThat(startTime.until(endTime, ChronoUnit.MILLIS)).isLessThan(1000);
    }

    @Test
    void testMod() {
        var rand = new Random();
        var arr = Arrays.stream((new Integer[100000]))
                .map((x) -> Math.abs(rand.nextInt()))
                .collect(Collectors.toList());

        var result = REMOSET.handleTestCase(arr);

        assertThat(result).isLessThan((int) (1e9 + 7));
    }
}