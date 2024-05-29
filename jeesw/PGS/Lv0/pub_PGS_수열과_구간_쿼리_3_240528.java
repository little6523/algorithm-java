class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        for (int[] q : queries) {
            for (int i = 0; i < arr.length; i++) {
                if (q[0] == i) {
                    int tmp = arr[q[0]];
                    arr[q[0]] = arr[q[1]];
                    arr[q[1]] = tmp;
                }
            }
        }
        answer = arr;
        return answer;
    }
}