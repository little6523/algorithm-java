public class Day08_05 {
    public static String solution(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder();

        char[] arr = my_string.toCharArray();

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            while (x < y)
            {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
                x++;
                y--;
            }
        }

        for (char ch : arr) {
            answer.append(ch);
        }

        return answer.toString();
    }
}
