import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        int[] arr = new int[9];
        int res = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < N.length(); i++) {
            if (Character.getNumericValue(N.charAt(i)) == 9) {
                arr[Character.getNumericValue(N.charAt(i)) - 3]++;
            } else {
                arr[Character.getNumericValue(N.charAt(i))]++;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == 6) {
                arr[i] = (arr[i] + 1) / 2;
            }
            res = Math.max(arr[i], res);
        }

        System.out.println(res);
    }
}