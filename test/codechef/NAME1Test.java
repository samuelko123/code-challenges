package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class NAME1Test {
    @Test
    void testMain() {
        var stdin = String.join(System.getProperty("line.separator"),
                "3",
                "tom marvoloriddle",
                "2",
                "lord",
                "voldemort",
                "cheap up",
                "1",
                "heapcup",
                "bruce wayne",
                "2",
                "bat",
                "man"
        );
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        NAME1.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo(
                String.join(System.getProperty("line.separator"),
                        "YES",
                        "YES",
                        "NO"
                )
        );
    }

    @Test
    void testSpeed() {
        var arr = new String[100000];
        Arrays.fill(arr, "lord voldemort");

        var startTime = Instant.now();
        NAME1.handleTestCase(List.of(arr), "tom marvoloriddle");
        var endTime = Instant.now();

        assertThat(startTime.until(endTime, ChronoUnit.MILLIS)).isLessThan(1000);
    }
}