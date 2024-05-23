import java.util.Scanner;

public class Day02_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n +" is " + (n%2 == 1 ? "odd" : "even" ));
    }
}
