import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        int[] cnt = new int[26];
        int odd_cnt = 0;
        int mid = -1;

        Arrays.fill(cnt, 0);

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            cnt[idx]++;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                mid = i;
                odd_cnt++;
            }
            if (odd_cnt > 1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (i == mid) cnt[i]--;
            cnt[i] /= 2;
            for (int j = 0; j < cnt[i]; j++) {
                result.append((char)(i + 'A'));
            }
        }

        if (mid != -1) result.append((char)(mid + 'A'));

        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < cnt[i]; j++) {
                result.append((char)(i + 'A'));
            }
        }

        System.out.println(result.toString());

        sc.close();
    }
}