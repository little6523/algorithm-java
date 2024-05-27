public class Day4_01 {
    public int solution(int num, int n) {
        int answer = 0;
        answer=num%n==0?1:0;
        return answer;
    }
}

//        if(num%n==0){
//            answer=1;
//        }