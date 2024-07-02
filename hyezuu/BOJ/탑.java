import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(stk.nextToken());
            }
            System.out.print(solution(arr));
        } catch (IOException e) {
        }
    }

    public static String solution(int[] arr) {
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr.length; i++) {
            while(!stack.isEmpty() && stack.peek().height <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Tower(i+1, arr[i]));
            }
            else {
                sb.append(stack.peek().index).append(" ");
                stack.push(new Tower(i+1, arr[i]));
            }
        }
        return sb.toString();
    }
}

class Tower {
    int index;
    int height;

    public Tower(int index, int height) {
        this.index = index;
        this.height = height;
    }
}


