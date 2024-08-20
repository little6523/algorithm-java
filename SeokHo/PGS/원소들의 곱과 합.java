class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum = 0;
        int multi = 1;

        for (int i = 0; i < num_list.length; i++) {
            sum += num_list[i];
            multi = multi * num_list[i];
        }

        int sumSquare = sum * sum;

        if (multi < sumSquare){
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}



// 제발 석호야 삼항연산자는 이렇게 멋있는 곳에서 하려고 하자
// 이상한 곳에 쓰려고 깝치지 말자
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;

        int sum  = 0;
        int mult = 1;

        for(int i : num_list) {
            sum += i;
            mult *= i;
        }

        answer = Math.pow(sum,2) > mult ? 1 : 0;

        return answer;
    }
}
