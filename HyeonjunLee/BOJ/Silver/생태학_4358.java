package Bakjoon; // https://www.acmicpc.net/problem/4358

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 생태학_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> trees = new HashMap<>();

        String tree;
        int total = 0;

        // 나무의 입력이 null이 아니거나 비어 있지 않은 동안만!
        while ((tree = br.readLine()) != null && (!tree.isEmpty())) {

            // 한 번도 등장하지 않은 나무라면 HashMap에 추가
            if (!trees.containsKey(tree)) {
                trees.put(tree, 1D);
            } else {
                // 이미 있던 나무라면 개수 +1
                trees.put(tree, trees.get(tree) + 1);
            }

            // 전체 나무 수 카운트
            total += 1;
        }

        // 키값 기준으로 정렬
        List<String> keyList = new ArrayList<>(trees.keySet());
        Collections.sort(keyList);

        // 정렬된 키값리스트를 통해 HashMap에서 각 나무의 개수를 가져오고 각 나무의 비율 계산
        for (String key : keyList) {
            System.out.printf("%s %.4f\n", key, (trees.get(key) / total) * 100);
        }
    }
}