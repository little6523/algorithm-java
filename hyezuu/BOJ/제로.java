import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];

        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solution(arr));
        br.close();
    }

    public static int solution(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for(int num : arr) {
            if(num == 0) {
                stack.pop();
            }
            else stack.push(num);
        }

        for(int num : stack){
            sum += num;
        }

        return sum;
    }
}
