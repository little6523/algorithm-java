import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = i * 2; j < (n-1) * 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                System.out.print("*");
            }
            for (int j = 0; j < (i+1) * 2; j++){
                System.out.print(" ");
            }
            for (int j = n-1; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}



// 마음에 들었던 풀이법
// 프린트도 무조건 for문으로 풀었는데 이런 방법도 있다니.....

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n+1; i++) {
            System.out.print("*".repeat(i));
            System.out.print(" ".repeat(2 * (n-i)));
            System.out.print("*".repeat(i));
            System.out.println();
        }

        for (int j = 1; j < n; j++) {
            System.out.print("*".repeat(n-j));
            System.out.print(" ".repeat(2*j));
            System.out.print("*".repeat(n-j));
            System.out.println();
        }
    }
}
