import java.util.Scanner;

public class Main {
    static int N;
    static boolean[][] drawingPaper = new boolean[101][101];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int cnt = 0;
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int iy = y; iy < y + 10; iy++) {
                for (int ix = x; ix < x + 10; ix++) {
                    if (!drawingPaper[iy][ix]) {
                        cnt++;
                        drawingPaper[iy][ix] = true;
                    }
                }
            }
        }

        System.out.println(cnt);

        scanner.close();
    }
}