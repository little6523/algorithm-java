class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        char[][] ch = new char[1000][m];
        
        for (int i = 0; i < (my_string.length() - 1) / m + 1; i++) {
            for (int j = 0; j < m; j++) {
                ch[i][j] = my_string.charAt(i * m + j);
            }
        }
        
        for (int i = 0; i < (my_string.length() - 1) / m + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (j == c - 1) answer += ch[i][j];
            }
        }
        
        return answer;
    }
}