import java.util.ArrayList;

public class Day19_03 {
    public static void main(String[] args) {
        int[] arr= {3,2,4,1,3};
        boolean[] flag = {true, false, true, false, false};
        solution(arr, flag);

    }
    public static int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(flag[i]) {
                for (int j = 0; j < arr[i]*2; j++) {
                    list.add(arr[i]);
                }
            }
            else
            {
                for (int j = 0; j < arr[i]; j++) {
                    list.remove(list.size()-1);
                }
            }

        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
