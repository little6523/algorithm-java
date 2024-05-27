public class Day03_01 {
    class Solution {
        public String solution(String str1, String str2) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < str1.length(); i++)
            {
                builder.append(str1.charAt(i)).append(str2.charAt(i));
            }

            return builder.toString();
        }
    }
}
