package codechef;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CS2023GIFTTest {
    @Test
    void testYes() {
        var stdin = "5 10 5";
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        CS2023GIFT.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo("YES");
    }

    @Test
    void testNo() {
        var stdin = "4 50 7";
        System.setIn(new ByteArrayInputStream(stdin.getBytes()));
        var stdout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdout));

        CS2023GIFT.main(new String[0]);

        assertThat(stdout.toString().trim()).isEqualTo("NO");
    }
}