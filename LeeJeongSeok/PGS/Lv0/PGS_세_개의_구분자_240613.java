import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> result = new ArrayList<>();

		StringBuilder current = new StringBuilder();
		for (char c : myStr.toCharArray()) {
			if (c == 'a' || c == 'b' || c == 'c') {
				// 누적된 문자열의 길이가 0보다 크면 배열에 지금까지 누적한 문자열을 저장한다.
				if (current.length() > 0) {
					result.add(current.toString());
					current = new StringBuilder();
				}
			} else {
				current.append(c);
			}
		}

		// 마지막에 남은 문자열을 더해준다.
		if (current.length() > 0) {
			result.add(current.toString());
		}

		if (result.isEmpty()) {
			return new String[]{"EMPTY"};
		} else {
			return result.toArray(new String[0]);
		}
    }
}
