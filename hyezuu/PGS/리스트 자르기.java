class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int start = n == 1 ? 0 : slicer[0];
        int end = n == 2 ? num_list.length - 1 : slicer[1];
        int step = n == 4 ? slicer[2] : 1;
        
        int[] answer = new int[(end - start + step) / step];
        
        int idx = 0;
        for (int i = start; i <= end; i += step) {
            answer[idx++] = num_list[i];
        }
        return answer;
    }
}
