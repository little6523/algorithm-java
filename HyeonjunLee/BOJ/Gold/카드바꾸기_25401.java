package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 카드바꾸기_25401 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> diffMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int answer;

        // 1. 숫자가 모두 같게 만드는 경우
        // 가장 많이 나온 숫자를 제외한 나머지 숫자를 가장 많이 나온 숫자로 바꾸가
        int most = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int num : list) {
            if (map.get(num) > most) {
                most = map.get(num);
            }
        }

        answer = n - most;

        // 2. 등차수열 만드는 경우
        int min = n - 1;  // N개의 카드가 있을 때 아무리 많이 바꿔도 최대 M - 2이므로 min을 M - 1로 설정
        int[] copyArr = new int[n + 1];

        // 2중 반복문을 통해 원본 배열에서 만들 수 있는 모든 공차 계산
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {

                // 등차수열 공식 사용
                // 공차: (뒤의 수 - 앞의 수) / (뒤의 수 인덱스 - 앞의 수 인덱스)
                // 초항: 앞의 수 - (앞의 수 인덱스 - 1) * 공차
                int diff = (arr[j] - arr[i]) / (j - i);   // 공차 계산
                int a0 = arr[i] - (i - 1) * diff;   // 초항 계산
                copy(copyArr, arr, n);   // 원본 배열과 결과 배열을 비교하기 위해 새로운 배열을 만들고 원본 복사

                // 초항과 공차에 따른 결과 계산
                for (int k = 1; k < n + 1; k++) {
                    copyArr[k] = a0 + (k - 1) * diff;
                }

                // 원본과 결과의 카드가 몇 개가 다른지 체크
                int check = differenceCheck(arr, copyArr, n);
                if (check < min) {
                    min = check;
                }
            }

            // 카드를 모두 갖게 만드는 경우가 answer에 저장되어 있으며,
            // 방금 계산한 등차수열 만드는 경우와 비교하여 더 작은 값을 answer에 저장
            if (answer > min) {
                answer = min;
            }
        }

        System.out.println(answer);
    }

    public static int differenceCheck(int[] arr1, int[] arr2, int n) {

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
            }
        }
        return count;
    }

    public static void copy(int[] arr1, int[] arr2, int n) {
        for (int i = 1; i < n + 1; i++) {
            arr1[i] = arr2[i];
        }
    }
}