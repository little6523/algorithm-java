package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 통계학_2108 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 숫자 빈도 계산
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                count.put(num, count.get(num) + 1);
            }

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }

            arr[i] = num;
        }

        arr = Arrays.stream(arr).sorted().toArray();

        // 1. 산술 평균
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println((int) Math.round(sum / n));

        // 2. 중앙값
        System.out.println(arr[n / 2]);

        // 3. 최빈값
        Set<Integer> keySet = count.keySet();
        List<Integer> list = new ArrayList<>(keySet);

        // 빈도순으로 키 정렬
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2);
            }
        });

        // 애초에 키가 하나면 그 키 출력
        if (n == 1) {
            System.out.println(list.get(0));
        } else {
            // 가장 빈도수가 높은 키를 계속 최신화하면서, 현재까지의 최대 빈도수와 같은 빈도수가 나오면 리스트에 추가
            // 더 높은 빈도수가 나오면 리스트 초기화 후, 해당 키 추가
            int most = 0;
            List<Integer> mostList = new ArrayList<>();
            for (int number : list) {
                if (count.get(number) > most) {
                    most = count.get(number);
                    mostList.clear();
                    mostList.add(number);
                } else if (count.get(number) == most) {
                    mostList.add(number);
                }
            }

            // 빈도수가 같은 애들끼리 모인 리스트 정렬
            Collections.sort(mostList);

            // 가장 높은 빈도수를 가진 키가 1개면 그거 출력
            // 아니면 2번째꺼 출력
            if (mostList.size() == 1) {
                System.out.println(mostList.get(0));
            } else {
                System.out.println(mostList.get(1));
            }
        }

        // 4. 범위
        System.out.println(max - min);
    }
}