//내 제출
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < n; j++) {
                System.out.print("*");
            }
            for (int j = i; j < n-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}




// 너무 길고 효율이 없어서 다른분 제출 참고
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i * 2; j < n * 2 -1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
