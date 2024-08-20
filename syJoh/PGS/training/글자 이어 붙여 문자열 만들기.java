class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        for(int idx: index_list){
            sb.append(my_string.charAt(idx));
            //sb.append(my_string.substring(idx, idx+1));
        }
        String answer = sb.toString();
        return answer;
    }
}
