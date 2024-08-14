package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class 수열_2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 초기에 큐의 크기가 아직 k가 안됬을 때는 계속 추가
            if (queue.size() < k) {
                sum += num;
                queue.offer(num);

                // 큐의 크기가 처음 k가 되었을 때 최댓값 갱신
                if (queue.size() == k) {
                    if (sum > max) {
                        max = sum;
                    }
                }
                continue;
            }

            // 이후, 큐의 크기는 계속 k이므로 최댓값 갱신
            // 그리고, 큐가 한 칸씩 이동하므로 앞에 있는 값은 버리고, 뒤에 있는 값은 추가
            if (queue.size() == k) {
                sum += num;
                queue.offer(num);
                sum -= queue.poll();

                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println(max);
    }
}