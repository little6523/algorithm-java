import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[t+1];

        for (int i = 1; i < t+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.solution(t, arr));
        br.close();
    }
    public int solution(int n, int[] arr) {
        int sum = 0;
        if(n<=2) {
            for(int a : arr){
                sum+=a;
            }
            return sum;
        }
        //dp[i] = i번째 계단까지 올라섰을때 밟지않을 계단의 합의 최솟값,
        //단 i번째 계단은 반드시 밟지 않을 계단으로 선택해야함
        int[] dp = new int[n+1];
        sum = arr[1]+arr[2]+arr[3];
        //아래 경우는 밟지않는것을 선택할 수 있음
        dp[1] = arr[1]; //첫번째 계단에 올라섰을 떄 밟지 않는계단 -> arr[1]. 최솟값 arr[i];
        dp[2] = arr[2]; //두번째 계단을 밟지 않는경우
        //첫번째 계단과 두번째 계단을 밟고 세번째 계단을 밟지않는 경우
        dp[3] = arr[3];
        for(int i=4; i<=n; i++){
            sum += arr[i];
            //네번째 계단부터는 앞에껄 무조건 밟아야한다.
            //네번째 계단부터는 세계단 전 또는 두계단전의 계단을 밟지 않아야 한다는 조건이 있다.
            //ㅅㅔ계단 연속으로 밟을 수 없기 때문이다.. 최솟값이므로 작은값을 dp[i]에 더해준다.
            dp[i] = Math.min(dp[i-2], dp[i-3]) + arr[i];
        }

        return sum-Math.min(dp[n-1], dp[n-2]);
    }

//    public int solution(int t, int[] arr) {
//        if(t==1) return arr[1];
//        //dp[i][j] : 현재까지 j개의 계단을 연속해서 밟고, i번째 계단까지 올라섰을때
//        //점수합의 최댓값. 단 i번째 계단은 반드시 밟아야 함
//        int[][] dp = new int[t+1][3];
//
//        dp[1][1] = arr[1];
//        dp[1][2] = 0;
//        dp[2][1] = arr[2];
//        dp[2][2] = arr[1]+arr[2];
//
//        for(int i=3; i<=t; i++){
//            //현재까지 1개의 계단을 연속해서 밟은 경우 -> 이전에 jump 한 경우 (두칸 전에서의 최댓값)
//            dp[i][1] += Math.max(dp[i-2][1], dp[i-2][2])+arr[i];
//            //현재까지 두개의 계단을 연속해서 밟은경우 -> 이전에 go 한경우 && 이전에 1개까지만 밟은경우
//            dp[i][2] += dp[i-1][1]+arr[i];
//        }
//        return Math.max(dp[t][1], dp[t][2]);
//    }
}
