class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        int temp = 0;

        System.arraycopy(arr, 0, answer, 0, arr.length);

        for (int i = 0; i < queries.length; i++) {
            temp = answer[queries[i][0]];
            answer[queries[i][0]] = answer[queries[i][1]];
            answer[queries[i][1]] = temp;
        }

        return answer;
    }
}
