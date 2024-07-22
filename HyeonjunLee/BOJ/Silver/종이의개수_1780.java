package Bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 종이의개수_1780 {

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

        map.put(-1, 0);
        map.put(0, 0);
        map.put(1, 0);

        checkSamePaper(paper, 0, 0, n);

        System.out.println(map.get(-1));
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

        if (count == size * size) {
            map.put(compareWithStart, map.get(compareWithStart) + 1);
        }

        else  {
            for (int i = x; i < x + size; i += size / 3) {
                for (int j = y; j < y + size; j += size / 3) {
                    checkSamePaper(paper, i, j, size / 3);
                }
            }
        }

    }
}