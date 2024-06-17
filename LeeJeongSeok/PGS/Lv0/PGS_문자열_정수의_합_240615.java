class Solution {
    public int solution(String num_str) {
        int sum = 0;
		String[] arr = num_str.split("");
		for (int i = 0; i < num_str.length(); i++) {
			sum += Integer.parseInt(arr[i]);
		}

		return sum;
    }
}