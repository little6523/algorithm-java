class Solution {
    public int[] solution(int[] arr) {
        int idx = 0;
        int leng = 1;
        
        while (leng < arr.length) {
            leng = (int) Math.pow(2, idx);
            idx++;
        }
        
        int[] answer = new int[leng];
        
        for (int i = 0; i < arr.length; i++)   answer[i] = arr[i];
        for (int i = arr.length; i < answer.length; i++)    answer[i] = 0;
        
        return answer;
    }
}