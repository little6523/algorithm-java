class Day2_05 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        int length = overwrite_string.length();
        answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + length);

        return answer;
    }
}