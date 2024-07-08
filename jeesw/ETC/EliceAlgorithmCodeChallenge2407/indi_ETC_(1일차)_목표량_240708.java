import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        StringBuilder subStr = new StringBuilder();
        int changeIdx = 0;
        boolean[] isIn = new boolean[10];
        int[] subCnt = new int[10];

        for (int i = 0; i < N.length(); i++) {
            isIn[N.charAt(i) - '0'] = true;
        }

        for (int i = N.length() - 2; i >= 0; i--) {
            int cur = N.charAt(i) - '0';
            int pre = N.charAt(i + 1) - '0';

            subCnt[pre]++;

            if (cur < pre) {
                changeIdx = i;
                break;
            }
        }

        subCnt[N.charAt(changeIdx) - '0']++;

        for (int i = N.charAt(changeIdx) - '0' + 1; i < 10; i++) {
            if (subCnt[i] != 0) {
                subStr.append((char) (i + '0'));
                subCnt[i]--;
                break;
            }
        }

        for (int i = 0; i < 10; i++) {
            while (subCnt[i] > 0) {
                subCnt[i]--;
                subStr.append((char) (i + '0'));
            }
        }

        StringBuilder result = new StringBuilder(N);
        result.replace(changeIdx, changeIdx + subStr.length(), subStr.toString());

        bw.write(result.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}


// 원본 .cpp 풀이

//#include <iostream>
//#include <string>
//
//using namespace std;
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	string N;
//	string sub_str;
//	int change_idx;
//	bool is_in[10];
//	int sub_cnt[10];
//
//	cin >> N;
//
//	for (int i = 0; i < 10; i++)	sub_cnt[i] = 0;
//
//	for (int i = 0; i < N.length(); i++)	is_in[N[i] - '0'] = true;
//
//	for (int i = N.length() - 2; i >= 0; i--) {
//		int cur = N[i] - '0';
//		int pre = N[i + 1] - '0';
//
//		sub_cnt[pre]++;
//
//		if (cur < pre) {
//			change_idx = i;
//			break;
//		}
//	}
//
//	sub_cnt[N[change_idx] - '0']++;
//
//	for (int i = N[change_idx] - '0' + 1; i < 10; i++) {
//		if (sub_cnt[i] != 0) {
//			sub_str.append(1, (char) (i + '0'));
//			sub_cnt[i]--;
//			break;
//		}
//	}
//
//	int sub_idx = change_idx + 1;
//
//	for (int i = 0; i < 10; i++) {
//		while (sub_cnt[i] > 0) {
//			sub_cnt[i]--;
//			sub_str.append(1, (char) (i + '0'));
//			sub_idx++;
//		}
//	}
//
//	N.replace(change_idx, sub_str.length(), sub_str);
//
//	cout << N << "\n";
//
//	return 0;
//}