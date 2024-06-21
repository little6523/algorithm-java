package Day22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day22_04 {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> set = new HashSet<>();
        for(int i : delete_list)
        {
            set.add(i);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i : arr)
        {
            if(!set.contains(i))
            {
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
