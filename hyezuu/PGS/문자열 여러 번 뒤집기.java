class Solution {
    static char[] arr;
    public String solution(String my_string, int[][] queries){
        arr = my_string.toCharArray();
        
        for(int[] query : queries){
            reverse(query[0], query[1]);
        }
        return String.valueOf(arr);
    }
    public void reverse(int lt, int rt){
        while(lt<rt){
            char tmp = arr[lt];
            arr[lt++] = arr[rt];
            arr[rt--] = tmp;    
        }    
    } 
}
