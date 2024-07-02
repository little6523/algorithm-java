import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            System.out.print(solution(n, arr));
        } catch (IOException e) {
        }
    }

    public static String solution(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        for(int num : arr){
            while(stack.isEmpty() || idx <= num){
                stack.push(idx++);
                sb.append("+").append("\n");
            }
            if(stack.peek() == num){
                stack.pop();
                sb.append("-").append("\n");
            }
            else return "NO";
        }
        return sb.toString();
    }
}


