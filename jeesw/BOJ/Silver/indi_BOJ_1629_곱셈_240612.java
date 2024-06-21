import java.util.Scanner;

public class Main {
    static long a, b, c, k;

    static long power(long b) {
        if (b == 0) return 1;
        if (b == 1) return a % c;

        k = power(b / 2) % c;
        if (b % 2 == 0) return (k * k) % c;
        return (k * k % c * a % c) % c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        System.out.println(power(b));
    }
}