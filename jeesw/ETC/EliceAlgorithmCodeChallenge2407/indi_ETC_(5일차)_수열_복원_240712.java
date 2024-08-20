// 성공한 개수: 12 / 25    시간 초과, 오답

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<Integer> permutation = new ArrayList<>();
    static Map<Integer, Integer> cnt = new HashMap<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            int tmp = Integer.parseInt(st.nextToken());
            permutation.add(tmp);
            cnt.put(tmp, cnt.getOrDefault(tmp, 0) + 1);
        }

        Collections.sort(permutation);

        for (int i = 1; i <= (int) Math.pow(2, n - 1); i++) {
            if (cnt.getOrDefault(permutation.get(i), 0) == 0) continue;
            else {
                result.add(permutation.get(i));

                if (result.size() == n) continue;

                for (int j = 1; j < i; j++) {
                    int sum = permutation.get(i) + permutation.get(j);
                    cnt.put(sum, cnt.getOrDefault(sum, 0) - 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(result.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

// .cpp 원본 풀이

//#include <iostream>
//#include <vector>
//#include <map>
//#include <cmath>
//#include <algorithm>
//
//using namespace std;
//
//int n;
//vector<int> permutation;
//map<int, int> cnt;
//vector<int> result;
//
//int main() {
//    ios::sync_with_stdio(0);
//    cin.tie(0);
//
//    cin >> n;
//
//    for (int i = 0; i < (int) pow(2, n); i++) {
//        int tmp;
//        cin >> tmp;
//        permutation.push_back(tmp);
//        cnt[tmp]++;
//    }
//
//    sort(permutation.begin(), permutation.end());
//    
//    for (int i = 1; i <= (int) pow(2, n - 1); i++) {
//        if (cnt[permutation[i]] == 0)   continue;
//        else {
//            result.push_back(permutation[i]);
//
//            if (result.size() == n) continue;
//
//            for (int j = 1; j < i; j++) {
//                cnt[permutation[i] + permutation[j]]--;
//            }
//        }
//    }
//
//    for (int i = 0; i < n; i++) {
//        cout << result[i] << ' ';
//    }
//
//    return 0;
//}