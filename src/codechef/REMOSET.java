package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/REMOSET

class REMOSET {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var arraySize = scanner.nextInt();
                    var arr = Arrays
                            .stream(new Integer[arraySize])
                            .map(x -> scanner.nextInt())
                            .collect(Collectors.toList());

                    var result = handleTestCase(arr);
                    System.out.println(result);
                });
    }

    protected static int handleTestCase(List<Integer> arr) {
        var evenCount = arr
                .stream()
                .filter(num -> num % 2 == 0)
                .count();
        var oddCount = arr.size() - evenCount;

        var result = combinationOfSubsequence((int) evenCount);
        result -= (oddCount == 0 ? 1 : 0);

        return result;
    }

    private static int combinationOfSubsequence(int n) {
        var mod = 1e9 + 7;
        return IntStream
                .range(0, n)
                .reduce(1, (acc, x) -> (int) ((acc * 2) % mod));
    }
}