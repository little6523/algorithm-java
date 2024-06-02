import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

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
        for (int i = 0; i < N; i++) {
            if (i >= val) {
                arr[lev] = i + 1;
                recursion(lev + 1, i);
            }
        }
    }
}