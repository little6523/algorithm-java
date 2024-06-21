import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
	ArrayList<Integer> list = new ArrayList<>();

	public int solution(int[] rank, boolean[] attendance) {
		for (int i = 0; i < rank.length; i++) {
			if (attendance[i]) {
				map.put(rank[i], i);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			list.add(entry.getValue());
		}

		return (list.get(0) * 10000) + (list.get(1) * 100) + (list.get(2));
	}
}