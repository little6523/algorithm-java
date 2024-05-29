public class Day06_02 {
    public int solution(int n, String control) {
        char[] charArray = control.toCharArray();
        int answer = 0;

        for (char c : charArray) {
            switch (c) {
                case 'w':
                    answer += 1;
                    break;
                case 's':
                    answer -= 1;
                    break;
                case 'd':
                    answer += 10;
                    break;
                default:
                    answer -= 10;
                    break;
            }
        }
        return answer;
    }
}
