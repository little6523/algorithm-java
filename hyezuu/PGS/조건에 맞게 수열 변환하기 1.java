class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        
        int idx = 0;
        for(int i : arr){
            boolean isEven = i>=50 && i%2==0;
            boolean isOdd = i<50 && i%2==1;
            
            answer[idx++] = isEven ? i/2 : isOdd ? i*2 : i ;
        }
        return answer;
    }
}
