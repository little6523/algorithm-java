import java.util.*;
import java.io.*;

public class Main {

	static int n, x, pairCount;
	static int[] arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		x = Integer.parseInt(br.readLine());

		pairCount = getPair();
		System.out.println(pairCount);
	}

	private static int getPair() {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		int count = 0;

		while (left < right) {
			int sum = arr[left] + arr[right];

			if (sum > x) {
				right--;
			} else if (sum < x) {
				left++;
			} else {
				count++;
				left++;
				right--;
			}
		}

		return count;
	}

}