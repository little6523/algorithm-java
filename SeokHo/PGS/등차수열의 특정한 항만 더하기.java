class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;    
        int[] arr = new int[included.length];

        for (int i = 0 ; i < included.length ; i++) {
            arr[i] = a + (d * i);
            if (included[i] == true) {   // ==true 생략 가능 !!
                answer += arr[i];
            }
        }

        return answer;
    }
}


// 조금더 간단하게 될 문제였다.
class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;

        for(int i = 0; i < included.length; i++){
            if(included[i]){
                answer +=  a + (d*i);
            }
        }

        return answer;
    }
}
