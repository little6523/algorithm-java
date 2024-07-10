import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> a = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ArrayList<Integer> tmp_v = new ArrayList<>(a.subList(start - 1, finish));
            Collections.sort(tmp_v);

            bw.write(tmp_v.get(k - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

//#include <iostream>
//#include <vector>
//#include <algorithm>
//
//using namespace std;
//
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	int n, m;
//	vector<int> a;
//	
//	cin >> n >> m;
//	
//	for (int i = 0; i < n; i++) {
//		int tmp;
//		cin >> tmp;
//		a.push_back(tmp);
//	}
//
//	for (int i = 0; i < m; i++) {
//		int start, finish, k;
//		vector<int> tmp_v;
//		cin >> start >> finish >> k;
//
//		for (int j = start - 1; j < finish; j++)	tmp_v.push_back(a[j]);
//		sort(tmp_v.begin(), tmp_v.end());
//
//		cout << tmp_v[k - 1] << "\n";
//	}
//
//	return 0;
//}