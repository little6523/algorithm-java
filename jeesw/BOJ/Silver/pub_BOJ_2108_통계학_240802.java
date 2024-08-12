import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N;
        List<Integer> num = new ArrayList<>();
        double Avg_;
        int Mid_, Mod_, crit;
        double sum = 0;
        int[] cnt = new int[8002];
        int mod_M = 0;
        List<Integer> arr = new ArrayList<>();
        int M = -4001;
        int m = 4001;

        N = sc.nextInt();

        Arrays.fill(cnt, 0);

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            num.add(temp);
            sum += temp;
            cnt[temp + 4000]++;
            mod_M = Math.max(mod_M, cnt[temp + 4000]);
            M = Math.max(M, temp);
            m = Math.min(m, temp);
        }

        Avg_ = Math.round(sum / N);
        if (Avg_ == -0) Avg_ = 0;
        
        Collections.sort(num);

        if (N % 2 == 1)
            Mid_ = num.get((N - 1) / 2);
        else
            Mid_ = (num.get(N / 2 - 1) + num.get(N / 2)) / 2;

        for (int i = 0; i < 8002; i++) {
            if (mod_M == cnt[i]) {
                arr.add(i - 4000);
            }
        }

        if (arr.size() > 1)
            Mod_ = arr.get(1);
        else
            Mod_ = arr.get(0);

        crit = M - m;

        System.out.println((int)Avg_);
        System.out.println(Mid_);
        System.out.println(Mod_);
        System.out.println(crit);

        sc.close();
    }
}