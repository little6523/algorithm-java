package Bakjoon; // https://www.acmicpc.net/problem/5430

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AC_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String command;
        int n;
        List<Integer> arr;
        String numbers;
        long dCount;
        int pointer;
        StringTokenizer st;

        // 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            // 명령 입력
            command = br.readLine().replaceAll("RR", "");

            // 숫자 개수 입력
            n = Integer.parseInt(br.readLine());

            // 숫자 배열 입력
            numbers = br.readLine().replaceFirst("\\[", "").replace("]", "");
            arr = new LinkedList<>();
            
            // ','를 기준으로 숫자만 추출
            st = new StringTokenizer(numbers, ",");
            for (int j = 0; j < n; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            // 명령의 D개수가 숫자 개수보다 많으면 에러
            dCount = command.chars()
                    .filter(c -> c == 'D')
                    .count();

            if (dCount > arr.size()) {
                sb.append("error\n");
                continue;
            }

            // 현재 배열이 뒤집혔는지 확인할 포인터 변수
            pointer = 0;
            
            // 명령에 따른 배열 조작
            for (int j = 0; j < command.length(); j++) {

                // R이면 배열 뒤집기 (convert (0) <---> (size() - 1))
                if (command.charAt(j) == 'R') {
                    if (pointer == 0) {
                        pointer = arr.size() - 1;
                    } else {
                        pointer = 0;
                    }

                } else {
                    // D이면 앞에서 원소 제거
                    arr.remove(pointer);
                    
                    // 포인터가 맨 뒤를 가리키고 있을 때 숫자를 빼면 포인터도 한 칸 앞으로 당김
                    if (pointer == arr.size()) {
                        pointer -= 1;
                    }
                }
            }
            
            // 포인터가 맨 뒤를 가리키고 있으면 거꾸로 출력해야 하므로 한 번 뒤집기
            if (pointer == arr.size() - 1) {
                Collections.reverse(arr);
            }

            sb.append(arr.toString().replaceAll(" ", "") + "\n");
        }
        System.out.println(sb);
    }
}