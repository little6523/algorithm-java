import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int cnt = 0;
        boolean[] check = new boolean[N];

        for(int i=0; i<N; i++){
            for(int j=i+1; j<=Math.min(i+K, N-1); j++){
                if(!check[i] && !check[j] && str.charAt(i) != str.charAt(j)){
                    check[j] = true;
                    cnt++;
                    break;
                }
            }
        }
        System.out.print(cnt);

        br.close();
    }
}
