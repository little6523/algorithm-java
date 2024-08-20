import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] binTree = new int[26][2];
    static boolean[] visited = new boolean[26];
    static List<Integer> preorderTraversal = new ArrayList<>();
    static List<Integer> inorderTraversal = new ArrayList<>();
    static List<Integer> postorderTraversal = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int idx1 = input[0].charAt(0) - 'A';

            if (!input[1].equals(".")) {
                int idx2 = input[1].charAt(0) - 'A';
                binTree[idx1][0] = idx2;
            } else {
                binTree[idx1][0] = -1;
            }

            if (!input[2].equals(".")) {
                int idx3 = input[2].charAt(0) - 'A';
                binTree[idx1][1] = idx3;
            } else {
                binTree[idx1][1] = -1;
            }
        }

        dfs(0);

        for (int i : preorderTraversal) bw.write((char) (i + 'A'));
        bw.write("\n");
        for (int i : inorderTraversal) bw.write((char) (i + 'A'));
        bw.write("\n");
        for (int i : postorderTraversal) bw.write((char) (i + 'A'));

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        visited[start] = true;
        preorderTraversal.add(start);
        if (binTree[start][0] != -1 && !visited[binTree[start][0]])
            dfs(binTree[start][0]);
        inorderTraversal.add(start);
        if (binTree[start][1] != -1 && !visited[binTree[start][1]])
            dfs(binTree[start][1]);
        postorderTraversal.add(start);
        visited[start] = false;
    }
}