package codechef;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/XOREQUAL

class XOREQUAL {
    private static final BigInteger MOD = BigInteger.valueOf((int) 1e9 + 7);

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = scanner.nextInt();
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var num = scanner.nextInt();
                    var result = handleTestCase(num);
                    System.out.println(result);
                });
    }

    protected static BigInteger handleTestCase(Integer num) {
        return BigInteger.TWO.modPow(BigInteger.valueOf(num - 1), MOD);
    }
}