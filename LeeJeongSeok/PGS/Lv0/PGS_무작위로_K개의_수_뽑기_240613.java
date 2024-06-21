import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
		int[] answer = new int[k];
		Arrays.fill(answer, -1);

		Set<Integer> set = new HashSet<>();
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i])) {
				answer[index++] = arr[i]; // 인덱스 계산이 좀 빡세네
				set.add(arr[i]);
			}

			if (index >= k) {
				break;
			}
		}

		return answer;
	}
}
