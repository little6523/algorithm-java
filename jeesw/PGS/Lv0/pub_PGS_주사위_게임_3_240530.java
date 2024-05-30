import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] num = {a, b, c, d};
        int[] map = {0, 0, 0, 0, 0, 0};
        ArrayList<Integer> pqr = new ArrayList<>(); 
        
        for (int i = 0; i < 6; i++) {
            for (int n : num) {
                if (i == n - 1) map[i]++;
            }
            if (map[i] > 0) pqr.add(i + 1);
        }
        
        switch (pqr.size()) {
            case 1:
                answer = 1111 * pqr.get(0);
                break;
            case 2:
                if (map[pqr.get(0) - 1] != 2)   answer = (map[pqr.get(0) - 1] > map[pqr.get(1) - 1]) ? (int) Math.pow((10 * pqr.get(0) + pqr.get(1)), 2) : (int) Math.pow((10 * pqr.get(1) + pqr.get(0)), 2);
                else    answer = (pqr.get(0) + pqr.get(1)) * Math.abs(pqr.get(0) - pqr.get(1));
                break;
            case 3:
                answer = 1;
                for (int i = 0; i < 3; i++) {
                    if (map[pqr.get(i) - 1] != 2)    answer *= pqr.get(i);
                }
                break;
            case 4:
                answer = pqr.get(0);
                break;
            default:
                break;
        }
        
        return answer;
    }
}