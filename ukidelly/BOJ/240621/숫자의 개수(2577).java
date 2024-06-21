import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        String sum = String.valueOf(a * b * c);
        int[] answer = new int[10];

        for (int i = 0; i <= 9; i++) {
            for (char ch : sum.toCharArray()) {
                int num = ch - '0';
                if (num == i) {
                    answer[i]++;
                }
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
