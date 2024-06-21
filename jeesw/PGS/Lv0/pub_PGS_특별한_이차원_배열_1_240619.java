// import java.util.stream.IntStream;

public class Solution {
    public int[][] solution(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (i == j) ? 1 : 0;
            }
        }
        return arr;
        
        // return IntStream.range(0, n).mapToObj(i -> IntStream.range(0, n).map(j -> i == j ? 1 : 0).toArray()).toArray(int[][]::new);
    }
}