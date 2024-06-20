package Day25;

public class Day25_01 {
    public static void main(String[] args) {
        solution(4);
    }

    public static int[][] solution(int n) {
        int[][] answer = new int [n][n];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int row = 0, col = 0;
        int dirIndex = 0;
        int index = 1;

        while (index <= n*n) {
            answer[row][col] = index++;
            int nextRow = row + dx[dirIndex];
            int nextCol = col + dy[dirIndex];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n)
            {
                dirIndex++;
                dirIndex %= 4;
            }
            else if(answer[nextRow][nextCol] != 0){
                dirIndex++;
                dirIndex %= 4;
            }
            row+=dx[dirIndex];
            col+=dy[dirIndex];
        }
        return answer;
    }
}
