// 처음에 DP로 풀은 풀이

// 그래프의 크기가 N이라 했을 때
// 시간복잡도가 O(N)이므로 이상은 없지만,
// 0 ~ N 까지 모두 저장하는 방식이므로
// 최대 10까지 간다면 등비수열의 합 공식에 의해
// 2 * 3072 * 6143 - 1 = 37742591
// DP로 대략 4천만번 0.4초 가량의 수행 결과를 갖음.
// 입출력도 고려한다면 0.8초 언저리의 수행이 들어감.
// (1억번의 수행을 1초라고 계산했을 때임.)


// import java.util.Scanner;

// public class Main {
//     static int N;
//     static char[][][] dp = new char[3100][6200][10];

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         N = scanner.nextInt();

//         int lev = 1;

//         while (N > 3) {
//             N /= 2;
//             lev++;
//         }

//         dp[0][2][0] = '*';
//         dp[1][1][0] = '*';
//         dp[1][3][0] = '*';
//         for (int i = 0; i < 5; i++) {
//             dp[2][i][0] = '*';
//         }

//         for (int i = 1; i < lev; i++) {
//             int x = 6 * (int)Math.pow(2, i - 1) - 1;
//             int y = 3 * (int)Math.pow(2, i - 1);
//             for (int j = 0; j < y; j++) {
//                 for (int k = 0; k < x; k++) {
//                     int tmp = (int)Math.pow(2, i - 1);
//                     dp[j][3 * tmp + k][i] = dp[j][k][i - 1];
//                     dp[3 * tmp + j][k][i] = dp[j][k][i - 1];
//                     dp[3 * tmp + j][6 * tmp + k][i] = dp[j][k][i - 1];
//                 }
//             }
//         }

//         int xx = 6 * (int)Math.pow(2, lev - 1) - 1;
//         int yy = 3 * (int)Math.pow(2, lev - 1);

//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < yy; i++) {
//             for (int j = 0; j < xx; j++) {
//                 if (dp[i][j][lev - 1] == '\0') {
//                     sb.append(' ');
//                 } else {
//                     sb.append(dp[i][j][lev - 1]);
//                 }
//             }
//             sb.append("\n");
//         }

//         System.out.print(sb.toString());
//         scanner.close();
//     }
// }



import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] stars;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        stars = new char[N][N * 2];

        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        makeStarTree(N, 0, 0);

        for (int i = 0; i < N; i++) {
            System.out.println(new String(stars[i]));
        }

        scanner.close();
    }

    static void printStar(int x, int y) {
        stars[x + 0][y + 2] = '*';

        stars[x + 1][y + 1] = '*';
        stars[x + 1][y + 3] = '*';

        stars[x + 2][y + 0] = '*';
        stars[x + 2][y + 1] = '*';
        stars[x + 2][y + 2] = '*';
        stars[x + 2][y + 3] = '*';
        stars[x + 2][y + 4] = '*';
    }

    static void makeStarTree(int n, int x, int y) {
        if (n == 3) {
            printStar(x, y);
            return;
        }
        makeStarTree(n / 2, x, y + n / 2);
        makeStarTree(n / 2, x + n / 2, y);
        makeStarTree(n / 2, x + n / 2, y + n);
    }
}