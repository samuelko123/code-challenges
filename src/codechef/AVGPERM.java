package codechef;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/AVGPERM

class AVGPERM {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var size = scanner.nextInt();
                    var list = handleTestCase(size);
                    System.out.println(getString(list, " "));
                });
    }

    protected static List<Integer> handleTestCase(Integer size) {
        var result = IntStream
                .rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());

        if (size >= 5) {
            result.add(0, result.remove(result.size() - 3));
        }

        if (size >= 4) {
            result.add(0, result.remove(result.size() - 1));
        }

        return result;
    }

    private static <T> String getString(List<T> list, String delimiter) {
        return list
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(delimiter));
    }
}