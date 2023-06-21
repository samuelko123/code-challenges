package codechef;

import java.util.Scanner;

// https://www.codechef.com/problems/CPLAY

class CPLAY {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            System.out.println(handleTestCase(scanner.nextLine()));
        }
    }

    protected static String handleTestCase(String str) {
        var scoreA = 0;
        var scoreB = 0;
        var shotsLeftA = 5;
        var shotsLeftB = 5;

        var arr = str.toCharArray();
        for (var i = 1; i <= 10; i++) {
            var c = arr[i - 1];
            var score = c == '1' ? 1 : 0;

            if (i % 2 == 1) {
                scoreA += score;
                shotsLeftA -= 1;
            } else {
                scoreB += score;
                shotsLeftB -= 1;
            }

            if (scoreA > scoreB + shotsLeftB) {
                return "TEAM-A " + i;
            }

            if (scoreB > scoreA + shotsLeftA) {
                return "TEAM-B " + i;
            }
        }

        for (var i = 11; i <= arr.length; i++) {
            var c = arr[i - 1];
            var score = c == '1' ? 1 : 0;

            if (i % 2 == 1) {
                scoreA += score;
            } else {
                scoreB += score;
                if (scoreA > scoreB) {
                    return "TEAM-A " + i;
                } else if (scoreB > scoreA) {
                    return "TEAM-B " + i;
                }
            }
        }

        return "TIE";
    }
}