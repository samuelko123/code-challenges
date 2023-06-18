package codechef;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/VOWMTRX

class VOWMTRX {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    scanner.nextInt(); // array size
                    var vowelsPerSlice = scanner.nextInt();
                    var str = scanner.next();
                    var arr = str
                            .chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.toList());

                    var result = handleTestCase(arr, vowelsPerSlice);

                    System.out.println(applyMod(result));
                });
    }

    protected static BigInteger handleTestCase(List<Character> arr, int vowelsPerSlice) {
        var total = BigInteger.ONE;

        var posList = getVowelPosList(arr);
        for (var i = 0; i < posList.size(); i += vowelsPerSlice) {
            if (i == 0) {
                continue;
            }

            var curr = posList.get(i);
            var prev = posList.get(i - 1);
            total = total.multiply(BigInteger.valueOf((long) curr - prev));
        }

        return total;
    }

    private static List<Integer> getVowelPosList(List<Character> arr) {
        var vowels = List.of('a', 'e', 'i', 'o', 'u');
        var posList = new ArrayList<Integer>();

        IntStream
                .range(0, arr.size())
                .forEach(i -> {
                    var c = arr.get(i);
                    if (vowels.contains(c)) {
                        posList.add(i);
                    }
                });

        return posList;
    }

    private static int applyMod(BigInteger num) {
        return num
                .mod(BigInteger.valueOf((long) 1e9 + 7))
                .intValue();
    }
}