import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        //d[i] = arr[1]+arr[2]+...+arr[i] -> d[i-1] + arr[i]
        int[] d = new int[n+1];
        //초기값 정하기
        //d[0] = 0;(배열은 기본 초기값이 0)
        st =  new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            //arr[i] = Integer.parseInt(st.nextToken());
            //d[i] = d[i-1]+arr[i];
            d[i] = d[i-1] + Integer.parseInt(st.nextToken());
        }
        while(m>0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(d[j]-d[i-1]);
            m--;
        }
        br.close();
    }
}
