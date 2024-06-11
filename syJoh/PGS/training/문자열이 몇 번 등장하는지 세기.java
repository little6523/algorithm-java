class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i=0; i<myString.length(); i++){
            String tmp = myString.substring(i);
            if(tmp.indexOf(pat)==0){
                answer++;
            }
        }
        return answer;
    }
}
/*
class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for(int i=0; i<myString.length(); i++){
            String str = myString.substring(0, i+1);
            if(str.endsWith(pat)){
                answer++;
            }
        }
        return answer;
    }
}
*/
