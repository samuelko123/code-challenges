package codechef;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.codechef.com/problems/NAME1

class NAME1 {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var testCaseCount = Integer.parseInt(scanner.nextLine());
        IntStream
                .range(0, testCaseCount)
                .forEach(testCase -> {
                    var parentName = scanner.nextLine().replace(" ", "");
                    var arrSize = Integer.parseInt(scanner.nextLine());
                    var childNames = Arrays
                            .stream(new Integer[arrSize])
                            .map(x -> scanner.nextLine())
                            .collect(Collectors.toList());

                    var result = handleTestCase(childNames, parentName);

                    System.out.println(result ? "YES" : "NO");
                });
    }

    protected static boolean handleTestCase(List<String> childNames, String parentName) {
        var arrParent = parentName.toCharArray();
        var arrChild = String.join("", childNames).toCharArray();
        Arrays.sort(arrParent);
        Arrays.sort(arrChild);

        var iParent = 0;
        var iChild = 0;
        while (true) {
            if (iChild == arrChild.length) {
                return true;
            }

            if (iParent == arrParent.length) {
                return false;
            }

            if (Objects.equals(arrParent[iParent], arrChild[iChild])) {
                iChild++;
            }

            iParent++;
        }
    }
}