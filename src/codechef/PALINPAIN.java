package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/PALINPAIN

class PALINPAIN {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var a = scanner.nextInt();
                    var b = scanner.nextInt();

                    var result = handleTestCase(a, b);

                    result.forEach(System.out::println);
                });
    }

    protected static List<String> handleTestCase(int a, int b) {
        var aIsEven = a % 2 == 0;
        var bIsEven = b % 2 == 0;

        if (!aIsEven && !bIsEven) {
            return List.of("-1");
        }

        if (a == 1 || b == 1) {
            return List.of("-1");
        }

        var result = new ArrayList<String>();

        if (aIsEven) {
            result.add("a".repeat(a / 2) + "b".repeat(b) + "a".repeat(a / 2));
        } else {
            result.add("a".repeat(a / 2) + "b".repeat(b / 2) + "a" + "b".repeat(b / 2) + "a".repeat(a / 2));
        }

        if (bIsEven) {
            result.add("b".repeat(b / 2) + "a".repeat(a) + "b".repeat(b / 2));
        } else {
            result.add("b".repeat(b / 2) + "a".repeat(a / 2) + "b" + "a".repeat(a / 2) + "b".repeat(b / 2));
        }

        return result;
    }
}