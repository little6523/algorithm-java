// 오답 9 / 10로 테스트 케이스 하나 틀림.

import java.util.*;
import java.io.*;

public class Main {
    static final int MIN = -99999999;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        Arrays.fill(dp, MIN);

        recursion(1, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i] > 0 ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    static void recursion(int node, int lev, int parent) {
        int cnt = 0;

        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int next : tree.get(node)) {
            int next_lev = lev + 1;
            if (parent == next) {
                cnt++;
                continue;
            }
            recursion(next, next_lev, node);
            dp[node] = Math.max(dp[node], node - dp[next]);
        }
        visited[node] = false;
        if (cnt == tree.get(node).size()) dp[node] = node;
    }
}



// 원본 .cpp 풀이

//#include <iostream>
//#include <vector>
//
//#define MIN -99999999
//
//using namespace std;
//
//vector<int> tree[100001];
//bool visited[100001];
//int dp[100001];
//
//void recursion(int node, int lev, int parent);
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//    int n;
//    cin >> n;
//
//    for (int i = 0; i < n - 1; ++i) {
//        int u, v;
//        cin >> u >> v;
//        tree[u].push_back(v);
//        tree[v].push_back(u);
//    }
//
//    fill(dp, dp + n + 1, MIN);
//
//    recursion(1, 0, 0);
//
//    for (int i = 1; i <= n; i++) {
//        cout << (dp[i] > 0 ? 1 : 0) << "\n";
//    }
//
//	return 0;
//}
//
//void recursion(int node, int lev, int parent) {
//    int cnt = 0;
//
//    if (visited[node]) {
//        return;
//    }
//
//    visited[node] = true;
//    for (int i = 0; i < tree[node].size(); i++) {
//        int next = tree[node][i];
//        int next_lev = lev + 1;
//        if (parent == next) {
//            cnt++;
//            continue;
//        }
//        recursion(next, next_lev, node);
//        dp[node] = max(dp[node], node - dp[next]);
//    }
//    visited[node] = false;
//    if (cnt == tree[node].size())   dp[node] = node;
//}