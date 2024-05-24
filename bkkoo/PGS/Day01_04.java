import java.util.Arrays;
import java.util.Scanner;

public class Day01_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        char[] array = a.toCharArray();

        a = "";
        for (int i = 0; i < array.length; i++) {
            if (Character.isUpperCase(array[i])) {
                a += Character.toLowerCase(array[i]);
            } else {
                a += Character.toUpperCase(array[i]);
            }
        }

        System.out.println(a);

    }
}
