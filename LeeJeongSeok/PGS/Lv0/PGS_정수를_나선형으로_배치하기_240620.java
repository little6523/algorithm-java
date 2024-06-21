class Solution {
    public int[][] solution(int n) {
		int[][] answer = new int[n][n];
		int value = 1;
		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;


		while (value <= n * n) {

			// 왼쪽 -> 오른쪽
			for (int i = colStart; i <= colEnd; i++) {
				answer[rowStart][i] = value;
				value++;
			}
			rowStart++;

			// 위 -> 아래
			for (int i = rowStart; i <= rowEnd; i++) {
				answer[i][colEnd] = value;
				value++;
			}
			colEnd--;

			// 오른쪽 -> 왼쪽
			for (int i = colEnd; i >= colStart; i--) {
				answer[rowEnd][i] = value;
				value++;
			}
			rowEnd--;

			// 아래 -> 위
			for (int i = rowEnd; i >= rowStart; i--) {
				answer[i][colStart] = value;
				value++;
			}
			colStart++;
		}

		return answer;
	}
}