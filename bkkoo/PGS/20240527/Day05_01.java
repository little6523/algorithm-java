public class Day05_01 {
    public static String solution(String code) {
        StringBuilder answer = new StringBuilder();

        char[] charArray = code.toCharArray();
        int size = charArray.length;
        boolean currentMode = true;

        for (int i = 0; i < size; i++) {
            if(charArray[i] == '1') {
                currentMode = !currentMode;
                continue;
            }

            if(currentMode)
            {
                if(i % 2 == 0)
                {
                    answer.append(charArray[i]);
                }
            }
            else
            {
                if(i % 2 == 1)
                {
                    answer.append(charArray[i]);
                }
            }
        }

        return answer.toString().isEmpty() ? "EMPTY" : answer.toString();
    }
}
