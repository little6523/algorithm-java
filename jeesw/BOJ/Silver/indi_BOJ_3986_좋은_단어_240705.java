import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < str.length(); j++) {
                if (!stack.empty() && stack.peek() == str.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(j));
                }
            }
            
            if (stack.empty()) {
                result++;
            }
        }
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}