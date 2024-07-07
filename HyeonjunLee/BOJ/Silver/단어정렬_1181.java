package Bakjoon; // https://www.acmicpc.net/problem/1181

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 중복 제거
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        // 단어 길이별로 단어 정리하기
        HashMap<Integer, List<String>> words = new HashMap<>();
        for (String word : hashSet) {
            
            // 처음 나오는 단어이면 HashMap에 추가
            if (!words.containsKey(word.length())) {
                List<String> list = new ArrayList<>();
                list.add(word);
                words.put(word.length(), list);
                continue;
            }

            // 아니라면 해당 단어를 기존의 리스트에 추가
            words.get(word.length()).add(word);
        }

        // 키값 기준 정렬하기
        List<Integer> keys = new ArrayList<>(words.keySet());
        Collections.sort(keys);

        // 각 길이별 단어 리스트를 정렬하면서 출력하기
        List<String> result;
        for (int i : keys) {
            result = words.get(i);
            Collections.sort(result);
            for (String str : result) {
                System.out.println(str);
            }
        }
    }
}
