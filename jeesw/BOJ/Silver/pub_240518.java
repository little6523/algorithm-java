import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int half = x / 2;
        Arrays.sort(a);

        Deque<Integer> small_a = new LinkedList<>();
        List<Integer> large_a = new ArrayList<>();

        for (int num : a) {
            if (num <= half) {
                small_a.offer(num);
            } else {
                large_a.add(num);
            }
        }

        int result = 0;
        while (!small_a.isEmpty() && !large_a.isEmpty()) {
            int sum = small_a.peekFirst() + large_a.get(large_a.size() - 1);
            if (sum == x) {
                result++;
                small_a.pollFirst();
                large_a.remove(large_a.size() - 1);
            } else if (sum < x) {
                small_a.pollFirst();
            } else {
                large_a.remove(large_a.size() - 1);
            }
        }

        System.out.println(result);
    }
}