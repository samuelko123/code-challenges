package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/CS2023_GYM

class CS2023GYM {
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
                    System.out.println(result);
                });
    }

    protected static int handleTestCase(List<Integer> arr) {
        return arr.get(1) / 2 + 1;
    }
}