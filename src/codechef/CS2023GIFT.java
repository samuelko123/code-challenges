package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// https://www.codechef.com/problems/CS2023_GIFT

class CS2023GIFT {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var arr = Arrays
                .stream(new Integer[3])
                .map(x -> scanner.nextInt())
                .collect(Collectors.toList());

        var result = handleTestCase(arr);
        System.out.println(result ? "YES" : "NO");
    }

    protected static boolean handleTestCase(List<Integer> arr) {
        return arr.get(0) + arr.get(2) >= arr.get(1);
    }
}