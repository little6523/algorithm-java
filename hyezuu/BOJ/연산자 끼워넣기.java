import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] nums;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        T.dfs(operators, nums[0], 1);

        System.out.print(max+"\n"+min);

        br.close();
    }

    void dfs(int[] operators, int result, int idx) {
        if(idx==nums.length) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        int tmp = result;
        for (int i = 0; i < 4; i++) {
            if(operators[i]>0){
                operators[i]--;
                switch(i){
                    case 0: result = result+nums[idx]; break;
                    case 1: result = result-nums[idx]; break;
                    case 2: result = result*nums[idx]; break;
                    case 3: result = result/nums[idx]; break;
                }
                dfs(operators, result, idx+1);
                operators[i]++;
                result = tmp;
            }
        }
    }
}
