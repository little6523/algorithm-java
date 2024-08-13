import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(nums, K));
        br.close();
    }

    static int solution(int[] nums, int k){
        int sum = 0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        int max = sum;

        for(int i=k; i<nums.length; i++){
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
