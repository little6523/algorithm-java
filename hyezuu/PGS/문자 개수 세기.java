class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char c : my_string.toCharArray()){
            int idx = Character.isUpperCase(c) ? c-'A' : c-'a'+26; 
            answer[idx]++;
        }
        return answer;
    }
}
