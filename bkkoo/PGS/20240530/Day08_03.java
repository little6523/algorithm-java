public class Day08_03 {
    public String solution(String my_string, int[] index_list) {
        StringBuilder answer = new StringBuilder();

        char[] arr = my_string.toCharArray();

        for (int i : index_list)
        {
            answer.append(arr[i]);
        }

        return answer.toString();
    }
}
