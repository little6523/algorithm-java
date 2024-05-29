class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        int tmp = 0; 
        for(int[] query: queries){
            tmp = answer[query[0]];
            answer[query[0]] = answer[query[1]];
            answer[query[1]] = tmp;
        }
  
        return answer;
    }
}
