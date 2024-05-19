import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long result = 1;
            int[] arr = new int[31];

            for (int j = N + 1; j <= M; j++) {
                arr[j]++;
            }

            for (int j = 1; j <= M - N; j++) {
                arr[j]--;
            }

            for (int j = M; j >= 1; j--) {
                if (arr[j] < 0) {
                    result /= j;
                } else if (arr[j] > 0) {
                    result *= j;
                }
            }

            System.out.println(result);
        }
    }
}