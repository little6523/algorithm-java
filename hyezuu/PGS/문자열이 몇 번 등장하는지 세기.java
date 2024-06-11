class Solution {
    public int solution(String myString, String pat) {
        int cnt = 0;
        while(myString.contains(pat)){
            myString = myString.substring(myString.indexOf(pat)+1);
            cnt++;
        }
        return cnt;
    }
}
