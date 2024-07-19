package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 역원소정렬_5648 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> numbers = new ArrayList<>();

        String line;
        int i = 0;

        // 첫 입력 시에만 입력 받는 횟수 지정
        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (i == 0 && st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                i++;
            }

            while (st.hasMoreTokens() && i < n + 1) {
                numbers.add(reverseNumber(st.nextToken()));
                i++;
            }

            if (i == n + 1) break;
        }

        Collections.sort(numbers);
        for (long num : numbers) {
            System.out.println(num);
        }

    }

    // 숫자 뒤집기
    static Long reverseNumber(String str) {

        String newStr = "";

        for (int i = str.length() - 1; i > -1; i--) {
            newStr += str.charAt(i);
        }

        return Long.parseLong(newStr);
    }
}