package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 햄버거분배_19941 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;
        char[] hp = br.readLine().toCharArray();

        // 어차피 햄버거의 위치로부터 ±k의 범위안에 사람이 있으면 그 사람이 먹을거다.
        for (int i = 0; i < n; i++) {
            if (hp[i] == 'H' && check(hp, i, n, k)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 현재 햄버거의 위치로부터 ±k의 범위안에 사람이 있으면 ture를 리턴하는 함수
    public static boolean check(char[] hp, int index, int n, int k) {
        int start, end;

        // 현재 인덱스가 k보다 작을 때 왼쪽으로 k범위 탐색하면 인덱스 벗어남
        if (index <= k) {
            start = 0;
        } else {
            start = index - k;
        }

        // 현재 인덱스가 n - k이상일 때 오른쪽으로 k범위 탐색하면 인덱스 벗어남
        if (index >= n - k) {
            end = n - 1;
        } else {
            end = index + k;
        }

        // 햄버거를 먹은 사람이 있으면 해당 사람은 먹었다는 표시로 변경 후 true 리턴
        for (int i = start; i <= end; i++) {
            if (hp[i] == 'P') {
                hp[i] = 'O';
                return true;
            }
        }
        return false;
    }
}