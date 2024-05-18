import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        int answer = 0;
        /* 시간초과
        for(int i=0; i<n;i++){
            if(list.contains(x-list.get(i))){
                answer++;

            }
        }
        */
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]+arr[j]==x){
                    answer++;
                    break;
                }
            }
        }
        br.close();
        System.out.println(answer);
    }
}
