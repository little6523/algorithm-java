import java.util.Scanner;

public class Main {
    static int n;
    static int[][] dp = new int[501][501];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int tmp;
        int result = 0;
        
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                tmp = scanner.nextInt();
                dp[i][j] = tmp + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[n][i]);
        }

        System.out.println(result);

        scanner.close();
    }
}

///////////////////////////////////////////
// 이 문제에선 시간 초과가 뜨지만 재귀 풀이 //
///////////////////////////////////////////

// import java.util.Scanner;

// public class Main {
//     static int n;
//     static int[][] triangle = new int[500][500];

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         n = scanner.nextInt();

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= i; j++) {
//                 triangle[i][j] = scanner.nextInt();
//             }
//         }

//         int max_val = recursion(0, 0);

//         System.out.println(max_val);

//         scanner.close();
//     }

//     static int recursion(int y, int x) {
//         if (y < n - 1) {
//             return triangle[y][x] + Math.max(recursion(y + 1, x), recursion(y + 1, x + 1));
//         } else {
//             return Math.max(triangle[y][x - 1], triangle[y][x]);
//         }
//     }
// }