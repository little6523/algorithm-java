import java.util.Scanner;

public class Main {
    static int N;
    static int[][] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        visited = new int[N][N];

        nQueen(0);

        System.out.println(cnt);
    }

    static void nQueen(int lev) {
        if (lev == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[lev][i] == 0) {
                for (int j = lev; j < N; j++) {
                    visited[j][i]++;
                    if (i + (j - lev) < N) visited[j][i + (j - lev)]++;
                    if (i - (j - lev) >= 0) visited[j][i - (j - lev)]++;
                }
                nQueen(lev + 1);
                for (int j = lev; j < N; j++) {
                    visited[j][i]--;
                    if (i + (j - lev) < N) visited[j][i + (j - lev)]--;
                    if (i - (j - lev) >= 0) visited[j][i - (j - lev)]--;
                }
            }
        }
    }
}