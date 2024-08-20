package Elice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Day2_Elice_Code_Challenge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 처음 숫자 리스트 초기화
        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int start, end, index;
        List<Integer> sortedArr;
        for (int i = 0; i < m; i++) {

            // 시작 인덱스, 끝 인덱스, 출력할 인덱스를 입력
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            index = Integer.parseInt(st.nextToken());

            // 해당 범위의 부분만 따로 추출하여 다른 리스트에 저장
            sortedArr = new ArrayList<>();
            for (int j = start - 1; j < end; j++) {
                sortedArr.add(arr.get(j));
            }

            // 추출한 리스트 정렬
            Collections.sort(sortedArr);

            // 원하는 인덱스 출력
            System.out.println(sortedArr.get(index - 1));
        }
    }
}
