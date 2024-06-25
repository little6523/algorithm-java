import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] basket = new int[n];

        for (int i = 0; i < n; i++) {
            basket[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int temp = basket[x - 1];
            basket[x - 1] = basket[y - 1];
            basket[y - 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}
