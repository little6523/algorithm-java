package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 블로그_21921 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = 0, sum = 0;
        int[] arr = new int[n];

        // 첫 x일 만큼은 합 누적만 수행
        for (int i = 0; i < x; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
        }

        int max = sum;

        // 이후, 슬라이딩을 통해 새로 들어온 값은 더하고, 맨 앞의 값은 뺀다.
        int count = 1;
        for (int i = x; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
            sum -= arr[start];
            start++;

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}