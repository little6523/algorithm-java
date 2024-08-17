import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        solution(K);

        br.close();
    }

    static void solution(int k){
        int[] a = new int[k+1];
        int[] b = new int[k+1];

        a[0] = 1;
        for(int i=1; i<=k; i++){
            a[i] = b[i-1];
            b[i] = a[i-1] + b[i-1];
        }

        System.out.print(a[k] + " "+ b[k]);
    }
}
