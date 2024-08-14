import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
        int[][] arr = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + num;
            }
        }

        for(int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // (x0, y0)
            int x0 = Integer.parseInt(st.nextToken());
            int y0 = Integer.parseInt(st.nextToken());
            // (x1, y1)
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int answer = arr[x1][y1] - arr[x1][y0 - 1] - arr[x0 - 1][y1] + arr[x0 - 1][y0 - 1];
            System.out.println(answer);
        }
    }
}
