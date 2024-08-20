class Solution {
    public int[] solution(int[] arr, int k) {

        int len = arr.length;
        
        for(int idx = 0; idx < len; idx++){
            if(k % 2 == 1){
                arr[idx] = arr[idx] * k;
            }else{
                arr[idx] = arr[idx] + k;
            }
        }
        return arr;
    }
}
