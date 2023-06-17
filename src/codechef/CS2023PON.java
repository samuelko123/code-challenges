package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/CS2023_PON

class CS2023PON {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var arraySize = scanner.nextInt();
                    var target = scanner.nextInt();
                    var arr = Arrays
                            .stream(new Integer[arraySize])
                            .map(x -> scanner.nextInt())
                            .collect(Collectors.toList());

                    var result = handleTestCase(arr, target);
                    System.out.println(result ? "YES" : "NO");
                });
    }

    protected static boolean handleTestCase(List<Integer> arr, Integer target) {
        return arr
                .stream()
                .filter(num -> (num & target) == target)
                .reduce(-1, (prev, curr) -> prev & curr)
                .equals(target);
    }
}