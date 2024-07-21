import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr = new int[2200][2200];
    static int[] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, N);

        for (int i = 0; i < 3; i++) {
            bw.write(cnt[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void recursion(int x, int y, int sz) {
        int prev = arr[y][x];
        boolean esc = false;

        if (sz == 1) {
            cnt[prev + 1]++;
            return;
        }

        for (int i = y; i < y + sz; i++) {
            for (int j = x; j < x + sz; j++) {
                if (prev != arr[i][j]) {
                    esc = true;
                    break;
                }
                prev = arr[i][j];
            }
            if (esc) break;
        }

        if (!esc) {
            cnt[prev + 1]++;
            return;
        }

        int newSize = sz / 3;
        recursion(x, y, newSize);
        recursion(x + newSize, y, newSize);
        recursion(x + newSize * 2, y, newSize);
        recursion(x, y + newSize, newSize);
        recursion(x + newSize, y + newSize, newSize);
        recursion(x + newSize * 2, y + newSize, newSize);
        recursion(x, y + newSize * 2, newSize);
        recursion(x + newSize, y + newSize * 2, newSize);
        recursion(x + newSize * 2, y + newSize * 2, newSize);
    }
}