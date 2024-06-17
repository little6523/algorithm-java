import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int s = i; s < n - 1; s++){
                System.out.print(" ");
            }
            for (int j = 1; j < (i + 1) * 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n-1; i++) {
            for (int s = 0; s < i + 1; s++){
                System.out.print(" ");
            }
            for (int j = (n * 2) - 1; j > (i + 1) * 2; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
