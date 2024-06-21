class Solution {
    public int[][] solution(int[][] arr) {
		int[][] answer = {};

		int row = arr.length;
		int col = arr[0].length;

		if (row < col) {
			int newRow = row + Math.abs(row - col);

			answer = new int[newRow][col];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					answer[i][j] = arr[i][j];
				}
			}
		} else {
			int newCol = col + Math.abs(row - col);

			answer = new int[row][newCol];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					answer[i][j] = arr[i][j];
				}
			}
		}

		return answer;
	}
}