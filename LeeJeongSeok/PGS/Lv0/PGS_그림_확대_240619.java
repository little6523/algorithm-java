class Solution {
    public String[] solution(String[] picture, int k) {
		int newRow = picture.length * k;
		int newCol = picture[0].length() * k;

		String[] answer = new String[newRow];

		for (int i = 0; i < newRow; i++) {
			StringBuilder sb = new StringBuilder();
			int row = i / k;
			
			for (int j = 0; j < newCol; j++) {
				int col = j / k;
				sb.append(picture[row].charAt(col));
			}
			
			answer[i] = sb.toString();
		}
        return answer;
    }
}