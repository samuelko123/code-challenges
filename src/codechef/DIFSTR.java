package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/DIFSTR

class DIFSTR {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = Integer.parseInt(scanner.nextLine());
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var arraySize = Integer.parseInt(scanner.nextLine());
                    var arr = Arrays
                            .stream(new Integer[arraySize])
                            .map(x -> scanner.nextLine())
                            .collect(Collectors.toList());

                    var result = handleTestCase(arr);

                    System.out.println(result);
                });
    }

    protected static String handleTestCase(final List<String> arr) {
        return IntStream
                .range(0, arr.size() + 1)
                .mapToObj(num -> {
                    var str = "0".repeat(arr.size()) + Integer.toBinaryString(num);
                    return str.substring(str.length() - arr.size());
                })
                .filter(str -> !arr.contains(str))
                .findFirst()
                .orElseThrow();
    }
}