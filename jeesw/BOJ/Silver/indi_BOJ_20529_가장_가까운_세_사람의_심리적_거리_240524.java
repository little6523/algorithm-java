import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            int m = 999999999;
            char[][] mbti = new char[N][4];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 4; j++) {
                    mbti[i][j] = input[i].charAt(j);
                }
            }

            // 16 * 3 이상이 되면 똑같은 MBTI가 반드시 3개 이상 나옴. (비둘기집 원리)
            if (N >= 48) {
                System.out.println(0);
            } else {
                for (int i = 0; i < N - 2; i++) {
                    for (int j = i + 1; j < N - 1; j++) {
                        for (int k = j + 1; k < N; k++) {
                            sum = 0;

                            for (int r = 0; r < 4; r++) {
                                if (mbti[i][r] != mbti[j][r]) sum++;
                                if (mbti[j][r] != mbti[k][r]) sum++;
                                if (mbti[k][r] != mbti[i][r]) sum++;
                            }

                            m = Math.min(m, sum);
                        }
                    }
                }
                System.out.println(m);
            }
        }
    }
}