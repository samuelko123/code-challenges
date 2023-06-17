package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CS2023PON {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        for (var i = 0; i < testCaseCount; i++) {
            var arraySize = scanner.nextInt();
            var target = scanner.nextInt();

            var arr = new ArrayList<Integer>();
            for (var j = 0; j < arraySize; j++) {
                arr.add(scanner.nextInt());
            }

            var result = handleTestCase(arr, target);
            System.out.println(result ? "YES" : "NO");
        }
    }

    protected static boolean handleTestCase(List<Integer> arr, Integer target) {
        return arr
                .stream()
                .filter(num -> (num & target) == target)
                .reduce(-1, (prev, curr) -> prev & curr)
                .equals(target);
    }
}