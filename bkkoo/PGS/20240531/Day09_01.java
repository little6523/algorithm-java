import java.util.ArrayList;

public class Day09_01 {
    public static void main(String[] args) {
        String[] arr = {"0123456789","9876543210","9999999999999"};
        solution(arr, 50000, 5, 5);
    }
    public static int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String str : intStrs) {
            int temp = Integer.parseInt(str.substring(s, s+l));
            if(temp > k)
            {
                list.add(temp);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
