class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        
        for(int i=0; i<=10; i++) {
            if(arr.length < Math.pow(2, i)) {
                length += (Math.pow(2, i) - arr.length);
                break;
            } else if(arr.length == Math.pow(2, i)) {
                break;
            }
        }
        
        int[] answer = new int[length];
        for(int i=0; i<answer.length; i++) {
            if(i < arr.length) {
                answer[i] = arr[i];
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
}
