class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        
        int x1 = intervals[0][0];
        int y1 = intervals[0][1];
        int x2 = intervals[1][0];
        int y2 = intervals[1][1];
        int[] answer = new int[(y1-x1+1)+(y2-x2+1)];

        System.arraycopy(arr, x1, answer, 0, y1-x1+1);
        System.arraycopy(arr, x2, answer, y1-x1+1,y2-x2+1);

        return answer;
    }
}
