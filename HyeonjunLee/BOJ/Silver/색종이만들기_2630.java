package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 색종이만들기_2630 {

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        map.put(0, 0);
        map.put(1, 0);

        checkSamePaper(paper, 0, 0, n);

        System.out.println(map.get(0));
        System.out.println(map.get(1));
    }

    static void checkSamePaper(int[][] paper, int x, int y, int size) {

        int compareWithStart = paper[x][y];

        int count = 0;

        // 시작 좌표로부터 나뉘어진 size만큼 탐색
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (compareWithStart == paper[i][j]) {
                    count++;
                }
            }
        }

        // 검사하고자 할 영역이 모두 같은 색이면 해당 색 카운트 + 1
        if (count == size * size) {
            map.put(compareWithStart, map.get(compareWithStart) + 1);
        }

        // 해당 검사 구역을 반으로 쪼개서 다시 탐색
        // 이 때, 각 구역의 시작점 위치는 현재 탐색할 size의 1/2씩 건너 뛴다.
        // ex) 검사할 영역의 한 변의 크기가 4이고, 원래의 한 변의 크기가 8이면
        // (0, 0) -> (0, 4) -> (4, 0) -> (4, 4) 순으로 시작점을 정한다.
        else  {
            for (int i = x; i < x + size; i += size / 2) {
                for (int j = y; j < y + size; j += size / 2) {
                    checkSamePaper(paper, i, j, size / 2);
                }
            }
        }

    }
}