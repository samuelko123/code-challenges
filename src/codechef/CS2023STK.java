package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/CS2023_STK

class CS2023STK {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var arraySize = scanner.nextInt();

                    var arr1 = Arrays
                            .stream(new Integer[arraySize])
                            .map(x -> scanner.nextInt())
                            .collect(Collectors.toList());

                    var arr2 = Arrays
                            .stream(new Integer[arraySize])
                            .map(x -> scanner.nextInt())
                            .collect(Collectors.toList());

                    var result = handleTestCase(arr1, arr2);

                    System.out.println(result);
                });
    }

    protected static String handleTestCase(List<Integer> arr1, List<Integer> arr2) {
        var count1 = getMaxCountOfConsecutiveNonZeroElements(arr1);
        var count2 = getMaxCountOfConsecutiveNonZeroElements(arr2);

        if (count1 > count2) {
            return "OM";
        } else if (count1 < count2) {
            return "ADDY";
        } else {
            return "DRAW";
        }
    }

    private static int getMaxCountOfConsecutiveNonZeroElements(List<Integer> arr) {
        var maxCount = 0;
        var currCount = 0;
        for (var num : arr) {
            if (num == 0) {
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            } else {
                currCount += 1;
            }
        }
        maxCount = Math.max(maxCount, currCount);

        return maxCount;
    }
}