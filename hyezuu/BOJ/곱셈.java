import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());
        long c = Long.parseLong(stk.nextToken());

        System.out.println(main.solution(a, b, c));
    }

    public long solution(long a, long b, long c) {
        if (b == 1) return a % c;
        long tmp = solution(a, b / 2, c);
        tmp = tmp * tmp % c;
        if (b % 2 == 0) return tmp;
        return tmp * a % c;
    }
}
