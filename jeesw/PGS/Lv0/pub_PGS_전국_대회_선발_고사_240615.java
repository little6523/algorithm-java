class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        boolean[] tmp = new boolean[rank.length];
        int cnt = 0;
        int r = 10000;
        
        for (int i = 0; i < attendance.length; i++)  tmp[rank[i] - 1] = attendance[i];
        
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i]) {
                int idx = 0;
                for (int j = 0; j < rank.length; j++) {
                    if (rank[j] == i + 1)   {
                        idx = j;
                        break;
                    }
                }
                answer += (idx * r);
                cnt++;
                r /= 100;
            }
            if (cnt == 3)   break;
        }
        
        return answer;
    }
}