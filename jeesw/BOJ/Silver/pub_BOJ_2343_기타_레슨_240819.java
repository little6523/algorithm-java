import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> v = new ArrayList<>();

    public static int blueRayCount(int amount) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < v.size() - 1; i++) {
            sum += v.get(i);
            if (sum + v.get(i + 1) > amount) {
                sum = 0;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = -1;
        int end = 0;
        int mid, result = 0;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            v.add(temp);
            end += temp;
            start = Math.max(temp, start);
        }

        while (start <= end) {
            mid = (start + end) / 2;

            if (blueRayCount(mid) <= m) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}