import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] frequency = new int[10];
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        for (int i = 0; i < N.length(); i++) {
            int n = Integer.parseInt(String.valueOf(N.charAt(i)));

            if (n == 6) {
                frequency[9] += 1;
            } else {
                frequency[n] += 1;
            }
        }

        int count = frequency[9] / 2;
        if (frequency[9] % 2 != 0) {
            count++;
        }

        frequency[9] = count;

        for (int i = 0; i < frequency.length; i++) {
            max = Math.max(max, frequency[i]);
        }

        System.out.println(Math.max(max, count));
    }
}