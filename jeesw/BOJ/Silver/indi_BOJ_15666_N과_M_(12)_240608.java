import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static Set<Integer> cnt = new HashSet<>();
    static List<Integer> list = new ArrayList<>(cnt);
    static int[] result = new int[8];

    public static void permutation(int lev, int prev) {
        if (lev == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int s : list) {
            if (s >= prev) {
                result[lev] = s + 1;
                permutation(lev + 1, s);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken()) - 1;
            cnt.add(tmp);
        }
        
        list.addAll(cnt);
        Collections.sort(list);
        
        permutation(0, 0);
    }
}