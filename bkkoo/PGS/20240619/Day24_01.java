package Day24;

public class Day24_01 {
    public int solution(String[] order) {
        int answer = 0;

        for (String str : order) {
            if (str.contains("cafe")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }
        return answer;
    }
}
