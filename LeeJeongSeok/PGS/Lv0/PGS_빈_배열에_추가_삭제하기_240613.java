import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> X = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (flag[i]) {
				int num = arr[i];
				for (int j = 0; j < num * 2; j++) {
					X.add(num);
				}
			} else {
				int num = arr[i];
                int size = X.size();
				// 엣지 케이스를 위한 방어 로직
				// X의 길이가 삭제하려는 수의 크기보다 작으면 지울 수 없기 때문에 추가했음
				if (size >= num) {
					for (int j = 0; j < num; j++) {
						X.remove(size - 1 - j); // X.size()로 하지 않은 이유는 remove가 발생할때마다 size()의 크기가 다르기 때문
					}
				}
			}
		}

		int[] answer = new int[X.size()];
		
		for (int i = 0; i < X.size(); i++) {
			answer[i] = X.get(i);
		}

		return answer;

	}
}
