package Day25;

public class Day25_02 {
    public int solution(int[][] arr) {
        int size = arr.length;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {

                if(arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
