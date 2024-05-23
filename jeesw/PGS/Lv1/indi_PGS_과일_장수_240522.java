import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int len = score.length;
        
        Arrays.sort(score);
        List<Integer> scoreList = new ArrayList<>();
        
        for (int s : score) {
            scoreList.add(s);
        }
        
        for (int i = 0; i < len / m; i++) {
            for (int j = 0; j < m - 1; j++) {
                scoreList.remove(scoreList.size() - 1);
            }
            answer += (scoreList.get(scoreList.size() - 1) * m);
            scoreList.remove(scoreList.size() - 1);
        }
        
        return answer;
    }
}