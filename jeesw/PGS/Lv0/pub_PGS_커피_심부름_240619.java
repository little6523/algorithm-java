import java.util.Arrays;

class Solution {
    public int solution(String[] order) {
        return Arrays.stream(order).map(str -> str.contains("cafelatte") ? 5000 : 4500).mapToInt(Integer::intValue).sum();
    }
}