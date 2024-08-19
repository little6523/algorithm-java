import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        long[] fibo = new long[46];

        fibo[0] = 1;
        fibo[1] = 1;

        for (int i = 2; i <= K; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }

        if (K == 1) {
            System.out.println("0 1");
        } else {
            System.out.println(fibo[K - 2] + " " + fibo[K - 1]);
        }
    }
}