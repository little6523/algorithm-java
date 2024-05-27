class Solution {
    public String solution(String code){
        StringBuilder sb = new StringBuilder();
        int mode = 0;
        for(int i=0; i<code.length(); i++){
            char tmp = code.charAt(i);
            if(tmp=='1'){
                mode = mode == 0 ? 1 : 0;               
            }            
            else if(i%2==mode) sb.append(tmp);           
        }
        return sb.length()==0 ? "EMPTY" : sb.toString();
    }
}
