public class Day11_01 {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] charArr = my_string.toCharArray();

        for ( char c : charArr ) {
            int index = (int)c;
            if(index < 97) {
                answer[index - 65]++;
            }
            else
            {
                answer[index - 71]++;
            }
        }

        return answer;
    }
}
