import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] interval = new int[4];
        int[][] board = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] =
                    board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + Integer.parseInt(
                        st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                interval[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(prefixSum(interval, board) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    //interval = {x1, y1, x2, y2}
    static int prefixSum(int[] interval, int[][] board) {
        int x1 = interval[0], y1 = interval[1], x2 = interval[2], y2 = interval[3];

        return board[x2][y2] + board[x1 - 1][y1 - 1] - board[x2][y1 - 1] - board[x1 - 1][y2];
    }
}
