import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Long, Long> fibo = new HashMap<>();
    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(divCon(n));
        scanner.close();
    }

    private static long divCon(long num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        if (num == 2) return 1;
        if (fibo.containsKey(num)) return fibo.get(num);

        long result;
        if (num % 2 == 0) {
            long tmp = num / 2;
            long an = divCon(tmp);
            long bn = divCon(tmp - 1);
            result = (bn * 2 + an) * an % MOD;
        } else {
            long tmp = (num + 1) / 2;
            long an = divCon(tmp);
            long bn = divCon(tmp - 1);
            result = (an * an + bn * bn) % MOD;
        }

        fibo.put(num, result);
        return result;
    }
}