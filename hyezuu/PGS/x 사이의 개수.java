import java.util.*;

class Solution {
    public int[] solution(String myString) {;
        return Arrays.stream(myString.split("x",-1)).mapToInt(x->x.length()).toArray();
        
        // int cnt=0;
        // String[] arr = myString.split("x",myString.length());
        // int[] answer = new int[arr.length];
        // for(int i=0; i<arr.length; i++){
        //     answer[i] = arr[i].length();
        // }
        // return answer;
    }
}
