class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        String str = s.toLowerCase();

        for(int idx = 0; idx < str.length(); idx++){
            if(str.charAt(idx) == 'p'){
                p += 1;
            }
            else if(str.charAt(idx) == 'y'){
                y += 1;
            }
        }
        if(p == 0 && y ==0){
            return true;
        }
        else if(p == y){
            return true;
        }
        else if(p != y){
            return false;
        }
        else{
            return false;
        }
    }
}
