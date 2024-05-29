public class Day05_02 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int size = included.length;
        for (int i = 0; i < size; i++) {
            if(included[i]) {
                answer += a + d*i;
            }
        }
        return answer;
    }
}
