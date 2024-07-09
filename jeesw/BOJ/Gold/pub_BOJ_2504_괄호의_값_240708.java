import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        Stack<Pair> stk = new Stack<>();
        boolean closed = false;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                if (stk.empty()) stk.push(new Pair('(', 2));
                else stk.push(new Pair('(', stk.peek().second * 2));
                closed = false;
            } else if (c == '[') {
                if (stk.empty()) stk.push(new Pair('[', 3));
                else stk.push(new Pair('[', stk.peek().second * 3));
                closed = false;
            } else if (c == ')') {
                if (stk.empty() || stk.peek().first != '(') {
                    result = 0;
                    break;
                }
                if (!closed) result += stk.peek().second;
                closed = true;
                stk.pop();
            } else {
                if (stk.empty() || stk.peek().first != '[') {
                    result = 0;
                    break;
                }
                if (!closed) result += stk.peek().second;
                closed = true;
                stk.pop();
            }
        }

        if (!stk.empty()) result = 0;

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Pair {
        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}