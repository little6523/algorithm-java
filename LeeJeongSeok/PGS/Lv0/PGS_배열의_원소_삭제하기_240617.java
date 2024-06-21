import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int answer[] = IntStream.of(arr)
            .filter(i -> !IntStream.of(delete_list).anyMatch(s -> s == i))
            .toArray();

        return answer;
    }
}