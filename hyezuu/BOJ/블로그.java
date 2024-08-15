import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitCounts = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            visitCounts[i] = Integer.parseInt(st.nextToken());
        }
        solution(visitCounts, X);
        br.close();
    }

    static void solution(int[] visitCounts, int x) {
        int max = 0 , sum = 0, cnt = 1;

        for(int i=0; i<x; i++){
            sum+=visitCounts[i];
        }

        max = sum;

        for(int i=x; i<visitCounts.length; i++){
            sum = sum - visitCounts[i-x] + visitCounts[i];
            if(sum > max){
                max = sum;
                cnt = 1;
            }
            else if(max == sum) cnt++;
        }
        if (max == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(max);
            System.out.print(cnt);
        }
    }
}
