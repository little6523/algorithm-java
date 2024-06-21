package Day25;

public class Day25_04 {
    public int solution(int[][] board, int k) {
        int row = board.length;
        int col = board[0].length;
        int answer = 0;

        for (int i = 0; i < row; i++) {
            if (i > k) {
                break;
            }
            for (int j = 0; j < col; j++) {
                if (i + j <= k) {
                    answer += board[i][j];
                    continue;
                }
                if (j > k) {
                    break;
                }
            }
        }
        return answer;
    }
}
