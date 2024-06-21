import java.util.*;

class Solution {
    public int solution(String[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i].length(), map.getOrDefault(arr[i].length(), 0) + 1);
			max = Math.max(max, map.get(arr[i].length()));
		}

		return max;
	}
}