class Solution {
    public int solution(String myString, String pat) {
        return myString.replace('A','a').replace('B','A').replace('a','B').contains(pat)? 1:0;
    }
}
