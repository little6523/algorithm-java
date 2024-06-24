import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(main.solution(arr));
        br.close();
    }
//dp풀이 2
    public String solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[12];
        for(int n : arr){
            dp[1] = 1; dp[2] = 2; dp[3] = 4;
            for(int i=4; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
            sb.append(dp[n]).append("\n");
        }
        return sb.toString();
    }
//dp풀이 1
//    public String solution(int[] arr) {
//        StringBuilder sb = new StringBuilder();
//        for(int n : arr){
//            int[] dp = new int[n+1];
//            dp[0] = 1;
//            //dp[i] 는 i를 1,2,3의 합으로 나타내는 경우의 수
//            //dp[4] = dp[1]+dp[2]+dp[3];
//            for(int i=1; i<=n; i++){
//                dp[i] += dp[i-1]; //1을 1,2,3으로 나타내는 경우의 수
//                if(i>=2) dp[i] += dp[i-2]; //2를 1,2,3의 합으로 나타내는 경우의 수
//                if(i>=3) dp[i] += dp[i-3]; //3을 1,2,3의 합으로 나타내는 경우의 수
//            }
//            sb.append(dp[n]).append("\n");
//        }
//        return sb.toString();
//    }
//ㅇ이건무슨 풀이??
//    public String solution(int[] nums) {
//        Stack<Integer> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        int[] arr = {1, 2, 3};
//
//        for (int n : nums) {
//            int cnt = 0;
//            stack.push(1);
//            stack.push(2);
//            stack.push(3);
//
//            while (!stack.isEmpty()) {
//                int tmp = stack.pop();
//                if (tmp > n) continue;
//                if (tmp == n) {
//                    cnt++;
//                    continue;
//                }
//
//                for (int a : arr) {
//                    stack.push(tmp + a);
//                }
//            }
//            sb.append(cnt).append("\n");
//        }
//        return sb.toString();
//    }
}
