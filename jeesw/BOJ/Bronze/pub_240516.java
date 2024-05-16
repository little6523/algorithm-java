import java.util.Scanner;

public class Main {
    static void savefn(int[] n, int j, int r) {
        for (int i = 0; i < j; i++) {
            for (int k = 0; k < 10; k++) {
                if (k == r % 10) {
                    n[k]++;
                    r /= 10;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int r = A * B * C;
        int[] N = new int[10];
        int j;

        if (r >= 1000000 && r < 10000000) {
            j = 7;
        } else if (r >= 10000000 && r < 100000000) {
            j = 8;
        } else {
            j = 9;
        }

        savefn(N, j, r);

        for (int i = 0; i < 10; i++) {
            System.out.println(N[i]);
        }
    }
}