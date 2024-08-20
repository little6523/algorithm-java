import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = a + b;

        String s = String.format("%s + %s = %s", a, b, sum);

        System.out.println(s);
    }
}
