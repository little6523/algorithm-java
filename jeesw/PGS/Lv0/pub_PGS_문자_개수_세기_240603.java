class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for (int i = 0; i < my_string.length(); i++) {
            int num = my_string.charAt(i);
            if (num >= 'A' && num <= 'Z') answer[num -'A']++;
            else answer[num - 'a' + 26]++;
        }
        
        return answer;
    }
}