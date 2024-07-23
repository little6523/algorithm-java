package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빈도정렬_2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // c는 왜 줬을까요??,,,
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 해쉬맵의 순서를 유지하기위해 LinkedHashMap 사용
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        // 입력을 받으면서 해쉬맵에 추가한다.
        // 만약 해쉬맵에 처음 들어오는 숫자면 (숫자, 1)
        // 들어왔던 숫자면 (숫자, 값 + 1)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(temp)) {
                hashMap.put(temp, 1);
                continue;
            }

            hashMap.put(temp, hashMap.get(temp) + 1);
        }

        // 정렬하기 위해 해쉬맵의 키 값들을 리스트에 저장한다.
        // 이 때, LikedList를 사용했으므로 키 값들은 들어온 순서대로 리스트에 들어간다.
        List<Integer> list = new ArrayList<>(hashMap.keySet());

        // Comparator를 사용해서 list를 정렬하는 기준을 정한다.
        // compare()는 o1과 o2를 비교하여, o1 > o2이면 1을 반환한다.
        // 그리고 Comparator는 compare의 값이 양수이면 두 인자의 자리를 교체한다. => 오름차순
        // 반대로, compare()의 인자 순서는 o1, o2일지라도, Integer.compare()의 인자 순서가 o2, o1이라면
        // o2 < o1 을 반환하므로, compare()는 음수를 반환하게 되어 순서가 바뀌지 않는다.
        // 즉, list에 들어온 순서대로 숫자는 순서를 유지하되, 빈도를 기준으로 내림차순 정렬이 된다.
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(hashMap.get(o2), hashMap.get(o1));
            }
        });

        for (int i : list) {
            for (int j = 0; j < hashMap.get(i); j++) {
                System.out.print(i + " ");
            }
        }
    }

}