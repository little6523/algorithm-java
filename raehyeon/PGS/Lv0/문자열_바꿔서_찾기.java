class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String str = "";

        for(int i=0; i<myString.length(); i++) {
            String s = String.valueOf(myString.charAt(i));
            if(s.equals("A")) {
                str += "B";
            } else if(s.equals("B")) {
                str += "A";
            }
        }
        
        if(str.contains(pat)) {
            answer += 1;
        }
        
        return answer;
    }
}
