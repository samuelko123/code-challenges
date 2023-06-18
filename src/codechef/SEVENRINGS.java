package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/SEVENRINGS

class SEVENRINGS {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var arr = Arrays
                            .stream(new Integer[2])
                            .map(x -> scanner.nextInt())
                            .collect(Collectors.toList());

                    var result = handleTestCase(arr);
                    System.out.println(result ? "YES" : "NO");
                });
    }

    protected static boolean handleTestCase(List<Integer> arr) {
        var total = arr.get(0) * arr.get(1);
        return total >= 10000 && total < 100000;
    }
}