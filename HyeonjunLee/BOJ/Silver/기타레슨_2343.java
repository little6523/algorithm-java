package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0, max = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 이분탐색 => 최솟값: 가장 길이가 긴 강의 / 최댓값: 모르니까 int형 최대값
        binarySearch(arr, m, max, sum);
        System.out.println(answer);
    }

    public static void binarySearch(int[] arr, int m, int start, int end) {
        while (start <= end) {
            int sum = 0, count = 0;
            int mid = (start + end) / 2;

            // mid는 강의를 담을 블루레이 한 개의 크기
            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    count++;
                    sum = arr[i];
                }
            }

            // 강의가 남아있으므로 블루레이 한 개 더 추가
            count++;

            // 블루레이 개수가 m보다 더 많다는 것은 블루레이 하나의 크기가 작다는 것
            // => 블루레이 크기를 늘려서 다시 탐색
            if (count > m) {
                start = mid + 1;
            }

            // 블루레이 개수가 m보다 더 적다는 것은 블루레이 하나의 크기가 크다는 것
            // => 블루레이 크기를 줄여서 다시 탐색
            if (count <= m) {
                end = mid - 1;

                // 찾는 과정에서 현재 블루레이의 크기가 지금까지 찾은 답보다 작으면 갱신
                if (answer > mid) {
                    answer = mid;
                }
            }
        }
    }
}