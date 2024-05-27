class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int tmp = numLog[0];
        for(int i=1; i<numLog.length; i++){
            int rs = numLog[i]-tmp;
            if(rs==1) sb.append("w");
            else if(rs==-1) sb.append("s");
            else if(rs>1) sb.append("d");
            else sb.append("a");
            tmp = numLog[i];
        }
        return sb.toString();
    }
}
