// 실패한 코드
//#include <iostream>
//#include <vector>
//
//using namespace std;
//
//int N, M;
//bool visited[50];
//vector<int> v[50];
//int cnt = 0;
//
//int main() {
//    ios::sync_with_stdio(0);
//    cin.tie(0);
//
//    int len;
//    bool check;
//
//    cin >> N >> M;
//
//    cin >> len;
//
//    for (int i = 0; i < len; i++) {
//        int tmp;
//        cin >> tmp;
//        visited[tmp - 1] = true;
//    }
//
//    for (int i = 0; i < M; i++) {
//        check = false;
//        cin >> len;
//        for (int j = 0; j < len; j++) {
//            int tmp;
//            cin >> tmp;
//            v[i].push_back(tmp);
//            if (visited[tmp - 1])   check = true;
//        }
//        if (check) {
//            for (int j = 0; j < len; j++) {
//                visited[v[i][j] - 1] = true;
//            }
//        }
//    }
//
//    for (int i = 0; i < M; i++) {
//        for (int j = 0; j < v[i].size(); j++) {
//            if (visited[v[i][j] - 1]) {
//                cnt++;
//                break;
//            }
//        }
//    }
//
//    cout << M - cnt << "\n";
//
//    return 0;
//}

// union-find
import java.io.*;
import java.util.*;

class Main {
    static int findParent(int[] parent, int v) {
        if (v != parent[v])
            parent[v] = findParent(parent, parent[v]);
        return parent[v];
    }

    static void unionFind(int[] parent, int x, int y) {
        int px = findParent(parent, x);
        int py = findParent(parent, y);
        if (px != py) {
            if (px < py)
                parent[py] = parent[px];
            else
                parent[px] = parent[py];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        
        int[] parent = new int[51];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < len; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            parent[tmp] = 0;
        }

        int[][] arr = new int[51][51];
        int[] arrlen = new int[51];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pnum = Integer.parseInt(st.nextToken());
            arrlen[i] = pnum;
            int tmp = Integer.parseInt(st.nextToken());
            arr[i][0] = tmp;

            for (int j = 1; j < pnum; j++) {
                int tmp2 = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp2;
                unionFind(parent, tmp, tmp2);
            }
        }

        int answer = M;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < arrlen[i]; j++) {
                if (findParent(parent, parent[arr[i][j]]) == 0) {
                    answer--;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}