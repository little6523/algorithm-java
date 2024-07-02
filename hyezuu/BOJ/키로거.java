import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            bw.write(solution(br.readLine()));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char a : input.toCharArray()) {
            if (Character.isAlphabetic(a) || Character.isDigit(a)) left.push(a);
            if (!left.isEmpty() && a == '<') right.push(left.pop());
            if (!right.isEmpty() && a == '>') left.push(right.pop());
            if (!left.isEmpty() && a == '-') left.pop();
        }

        for (char a : left) {
            sb.append(a);
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        return sb.toString();
    }

//    public static String solution(String input) {
//        StringBuilder sb = new StringBuilder();
//        int idx = 0;
//
//        for (char a : input.toCharArray()) {
//            if(Character.isAlphabetic(a) || Character.isDigit(a)) {
//                sb.insert(idx++, a);
//            }
//            if (a == '>' && idx+1<=sb.length()) idx++;
//            else if (idx > 0) {
//                if(a == '-') sb.deleteCharAt(--idx);
//                else if(a =='<') idx--;
//            }
//        }
//
//        return sb.toString();
//    }
}


