import java.util.Scanner;

public class Main {
    static int N;
    static int[] a = new int[11];
    static int[] cur = new int[11];
    static int[] op = new int[4];
    static int max_, min_;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = scanner.nextInt();
        }

        max_ = -1000000000;
        min_ = 1000000000;
        cur[0] = a[0];

        recursion(1);

        System.out.println(max_);
        System.out.println(min_);

        scanner.close();
    }

    static void recursion(int lev) {
        if (lev == N) {
            max_ = Math.max(max_, cur[lev - 1]);
            min_ = Math.min(min_, cur[lev - 1]);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            op[i]--;
            switch (i) {
                case 0:
                    cur[lev] = cur[lev - 1] + a[lev];
                    break;
                case 1:
                    cur[lev] = cur[lev - 1] - a[lev];
                    break;
                case 2:
                    cur[lev] = cur[lev - 1] * a[lev];
                    break;
                case 3:
                    cur[lev] = cur[lev - 1] / a[lev];
                    break;
            }

            recursion(lev + 1);

            cur[lev] = 0;
            op[i]++;
        }
    }
}