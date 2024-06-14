import java.util.*;

class Solution {
    public int[] solution(int[] arr) {

		List<Integer> stk = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (stk.isEmpty()) { // stk이 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더한다.
				stk.add(arr[i]);
			} else if (stk.get(stk.size() - 1) == arr[i]) { // stk에 원소가 있고, stk의 마지막 원소가 arr[i]와 같으면 stk의 마지막 원소를 stk에서 제거하고 i에 1을 더한다.
				stk.remove(stk.size() - 1);
			} else { // stk에 원소가 있는데 stk의 마지막 원소가 arr[i]와 다르면 stk의 맨 마지막에 arr[i]를 추가하고 i에 1을 더한다.
				stk.add(arr[i]);
			}
		}

		if (stk.isEmpty()) {
			return new int[]{-1};
		}

		int[] answer = new int[stk.size()];
		for (int i = 0; i < stk.size(); i++) {
			answer[i] = stk.get(i);
		}

		return answer;
	}
}
