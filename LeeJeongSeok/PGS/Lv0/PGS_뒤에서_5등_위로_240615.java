import java.util.*;

class Solution {
    static final int SMALLEST_NUMBER_LIMIT = 5;

	public int[] solution(int[] num_list) {
		Arrays.sort(num_list);
		return Arrays.copyOfRange(num_list, SMALLEST_NUMBER_LIMIT, num_list.length);
	}
}