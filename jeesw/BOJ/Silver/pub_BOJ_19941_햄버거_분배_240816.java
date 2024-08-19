import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int result = 0;
        char[] arr = str.toCharArray();

        for (int i = 0; i < N; i++) {
            if (arr[i] != 'P') continue;

            boolean isFind = false;

            for (int j = K; j >= 1; j--) {
                if (i - j < 0) continue;

                if (arr[i - j] == 'H') {
                    result++;
                    isFind = true;
                    arr[i - j] = '.';
                    break;
                }
            }

            if (!isFind) {
                for (int j = 1; j <= K; j++) {
                    if (i + j >= N) break;

                    if (arr[i + j] == 'H') {
                        result++;
                        arr[i + j] = '.';
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}