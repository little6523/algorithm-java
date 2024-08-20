import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int cur = 1;
        int result = 0;
        Stack<Pair<Character, Integer>> stk = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cur *= stk.peek().getKey() - '0';
                stk.pop();
                stk.push(new Pair<>('(', cur));
            }
            else if (str.charAt(i) == ')') {
                while (!stk.isEmpty() && stk.peek().getKey() != '(') {
                    int tmp = stk.peek().getValue();
                    stk.pop();
                    result += tmp;
                }
                stk.pop();
                cur = !stk.isEmpty() ? stk.peek().getValue() : 1;
            }
            else {
                stk.push(new Pair<>(str.charAt(i), cur));
            }
        }
        
        while (!stk.isEmpty()) {
            result += stk.peek().getValue();
            stk.pop();
        }
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    static class Pair<K, V> {
        private K key;
        private V value;
        
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}

// .cpp 풀이

//#include <iostream>
//#include <string>
//#include <stack>
//
//using namespace std;
//
//int main() {
//	ios::sync_with_stdio(0);
//	cin.tie(0);
//
//	string str;
//	int cur = 1;
//	int result = 0;
//	stack<pair<char, int>> stk;
//
//	cin >> str;
//
//	for (int i = 0; i < str.length(); i++) {
//		if (str[i] == '(') {
//			cur *= stk.top().first - '0';
//			stk.pop();
//			stk.push({str[i], cur});
//		}
//		else if (str[i] == ')') {
//			while (!stk.empty() && stk.top().first != '(') {
//				int tmp = stk.top().second;
//				stk.pop();
//				result += tmp;
//			}
//			stk.pop();
//			cur = !stk.empty() ? stk.top().second : 1;
//		}
//		else {
//			stk.push({ str[i], cur });
//		}
//	}
//
//	while (!stk.empty()) {
//		result += stk.top().second;
//		stk.pop();
//	}
//
//	cout << result << "\n";
//
//	return 0;
//}