import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sArr = br.readLine().split(" ");
        int N = Integer.parseInt(sArr[0]);
        int L = Integer.parseInt(sArr[1]);

        for (int i = L; i <= 100; i++) {
            long sum = N - (i * (i - 1)) / 2;

            if (sum % i == 0) {
                long a = sum / i;
                if (a >= 0) {
                    for (int j = 0; j < i; j++) {
                        System.out.print((a + j) + " ");
                    }
                    return;
                }
            }
        }
        System.out.println("-1");
    }
}
