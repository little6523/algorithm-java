import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        System.out.print(main.solution(arr, x));
        br.close();
    }

    public int solution(int[] arr, int x) {
        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length - 1;
        int cnt = 0;

        while (lt < rt) {
            if (arr[lt] + arr[rt] > x) rt--;
            else if (arr[lt] + arr[rt] < x) lt++;
            else {
                cnt++;
                lt++;
                rt--;
            }
        }
        return cnt;
    }
}

