package codechef;

import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/PCJ188

class PCJ188 {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var size = scanner.nextInt();
                    var result = handleTestCase(size);
                    System.out.println(result);
                });
    }

    protected static int handleTestCase(int size) {
        int start = size % 2 == 0 ? 2 : 1;

        var total = 0;
        for (var i = start; i <= size; i += 2) {
            total += i * i;
        }

        return total;
    }
}