import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visited = new boolean[N];

        recursion(0, 0);
    }

    private static void recursion(int lev, int val) {
        if (lev == M) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                if (val < i) {
                    arr[lev] = i;
                    recursion(lev + 1, i);
                }
                visited[i - 1] = false;
            }
        }
    }
}