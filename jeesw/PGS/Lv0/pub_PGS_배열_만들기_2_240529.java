import java.util.*;

class Solution {

    public int[] solution(int l, int r) {
        int[] answer = {};
        ArrayList<Integer> vector = new ArrayList<>();
        
        // 각각 자리수로 이진수 취급
        // 000000 ~ 555555 까지 2^6=64가지 경우
        for (int i = 0; i < 64; i++) {
            int val = 0;
            String bin = Integer.toBinaryString(i);
            for (int j = bin.length() - 1; j >= 0; j--) {
                if (bin.charAt(j) == '1')   val += 5 * Math.pow(10, bin.length() - j - 1);
            }
            if (val >= l && val <= r)   vector.add(val);
        }
        if (vector.isEmpty())   vector.add(-1);
        answer = vector.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}