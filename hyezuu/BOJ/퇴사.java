import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N+1][2];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        getMaxProfit(schedule);
    }

    static void getMaxProfit(int[][] schedule){
        int quitDate = schedule.length;
        int[] profits = new int[quitDate];
        int maxProfit = 0;
        for(int i=quitDate-1; i>=1; i--){
            int term = schedule[i][0];
            int profit = schedule[i][1];
            if(i+term>quitDate){
                profits[i]=term+i==quitDate ? profit : 0;
                maxProfit = Math.max(profits[i], maxProfit);
                continue;
            }
            int tmp = 0;
            for(int j=i+term; j<quitDate; j++){
                tmp = Math.max(tmp, profits[j]);
            }
            profits[i]=schedule[i][1]+tmp;
            maxProfit = Math.max(profits[i], maxProfit);
        }
        System.out.print(maxProfit);
    }
}
