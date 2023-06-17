package codechef;

import java.math.BigInteger;
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

        var result = getCountOfPossibleSubsets((int) evenCount)
                .subtract(BigInteger.valueOf(oddCount == 0 ? 1 : 0));

        return applyMod(result);
    }

    private static BigInteger getCountOfPossibleSubsets(int arrSize) {
        return BigInteger
                .valueOf(2)
                .pow(arrSize);
    }

    private static int applyMod(BigInteger num) {
        return num
                .mod(BigInteger.valueOf((long) 1e9 + 7))
                .intValue();
    }
}