import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        int s = 0;
        int e = 0;
        int len = 0;
        for(int i=0; i<str_list.length; i++){
            if(str_list[i].equals("l")){
                e = i;
                len = i;
                break;
            }
            else if(str_list[i].equals("r")){
                s = i+1;
                len = str_list.length-s;
                break;
            }
        }
        String[] answer = new String[len];
        
        System.arraycopy(str_list, s, answer, 0, len);
        
        return answer;
        

        // for(int i=0; i<str_list.length; i++){
        //     if(str_list[i].equals("l")){
        //         return Arrays.copyOfRange(str_list,0,i);
        //     }
        //     else if(str_list[i].equals("r")){
        //         return Arrays.copyOfRange(str_list,i+1,str_list.length);
        //     }
        // }
        // return new String[0];
    }
}
