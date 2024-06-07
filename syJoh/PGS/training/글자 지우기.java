class Solution {
    public String solution(String my_string, int[] indices) {
        /*
        StringBuilder sb = new StringBuilder(my_string);
        for(int i: indices){
            sb.deleteCharAt(i);
            System.out.println(sb);
        }
        String answer = sb.toString(); // "pororapemep"
        */
        String answer = "";
        String[] arr = my_string.split("");
        for(int i : indices){
            arr[i] = "";
        }
        for(String s : arr){
            if(!s.equals("")){
                answer += s;
            }
        }
        return answer;
    }
}
