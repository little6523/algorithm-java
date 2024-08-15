import java.io.*;
import java.util.*;

class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(nums));
        br.close();
    }

    static int solution(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if((nums[j] - nums[i]) % (j-i) != 0) continue;
                int diff = (nums[j] - nums[i]) / (j-i);
                int cnt = 0;
                for(int k=0; k<nums.length; k++) {
                    if(nums[k] != (k-i) * diff + nums[i]){
                        cnt ++;
                    }
                }
                min = Math.min(min, cnt);
            }
        }
        return min;
    }
}
