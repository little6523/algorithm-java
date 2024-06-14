class Solution {
    public int solution(int[] arr1, int[] arr2) {

		// 배욜의 길이가 같다면 각 배열에 있는 모든 원소의 합을 비교하여 다르면 더 큰쪽, 같다면 같다.
		if (arr1.length == arr2.length) {
			int arr1Result = sum(arr1);
			int arr2Result = sum(arr2);

			return (arr1Result > arr2Result) ? 1 : (arr1Result < arr2Result) ? -1 : 0;
		} else {
			return (arr1.length > arr2.length) ? 1 : (arr1.length < arr2.length) ? -1 : 0;
		}
	}

	private int sum(int[] arr) {
		int sum = 0;

		for (int i : arr) {
			sum += i;
		}

		return sum;
	}
}