class Solution {
    public int[] solution(int[] arr) {

		int num = 1;
		int count = 0;

		while (true) {
			if (num >= arr.length) {
				count = num - arr.length;
				break;
			}

			num = num * 2;
		}

		int[] answer = new int[arr.length + count];

		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}

		return answer;
	}
}