import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr = new int[128][128];
    static int W = 0;
    static int B = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        recursion(N, 0, 0);

        System.out.println(W);
        System.out.println(B);

        scanner.close();
    }

    static void recursion(int size, int x, int y) {
        int check = arr[y][x];
        int mid = size / 2;
        
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (check == 0 && arr[i][j] == 1)
                    check = 2;
                else if (check == 1 && arr[i][j] == 0)
                    check = 2;
            }
        }

        if (check == 2) {
            recursion(mid, x, y);
            recursion(mid, x + mid, y);
            recursion(mid, x, y + mid);
            recursion(mid, x + mid, y + mid);
            return;
        }

        if (check == 0)    W++;
        else    B++;
    }
}