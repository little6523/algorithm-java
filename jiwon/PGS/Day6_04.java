class Day6_04 {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i = 0; i<queries.length; i++){
            int[] query = queries[i];
            int idxi = query[0];
            int idxj = query[1];

            int tmp = arr[idxi];
            arr[idxi]=arr[idxj]; // 0 1 2 3 4    3 1 2 3 4
            arr[idxj]=tmp; //3 1 2 0 4
        }
        return arr;
    }
}