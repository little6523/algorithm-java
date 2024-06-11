public class Day17_02 {
    public int solution(String myString, String pat) {
        int answer = 0;
        int len = myString.length() - pat.length();

        for (int i = 0; i <= len; i++) {
            if (myString.substring(i, i + pat.length()).equals(pat)) {
                answer++;
            }
        }

        return answer;
    }
}
