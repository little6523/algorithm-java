import java.util.Scanner;

public class Main {
    public static int A, B;
    public static int cnt = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        scanner.close();

        bfs();

        System.out.println(cnt);
    }

    public static void bfs() {
        while (true) {
            if (A == B) break;
            else if (A > B) {
                cnt = -1;
                break;
            }

            if (B % 2 == 0) B /= 2;
            else if (B % 10 == 1) B = (B - 1) / 10;
            else {
                cnt = -1;
                break;
            }
            cnt++;
        }
    }
}