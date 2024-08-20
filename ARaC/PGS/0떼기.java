class Solution {
    public String solution(String n_str) {
        String answer = "";
        int len = n_str.length();
        Boolean check = false;
        
        for(int idx = 0; idx < len; idx++){
            if(n_str.charAt(idx) == '0' && check == false){
                continue;
            }
            else{
                check = true;
                answer += n_str.charAt(idx);
            }
        }
      
        return answer;
    }
}
