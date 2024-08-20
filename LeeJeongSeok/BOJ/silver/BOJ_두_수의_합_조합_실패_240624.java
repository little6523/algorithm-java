import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, x, pairCount;
	static int[] arr;
	static int[] candidate;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		candidate = new int[2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		x = Integer.parseInt(br.readLine());

		dfs(0, 0);
		System.out.println(pairCount);
	}

	// 순열 방식이 아니라 조합방식으로 가야한다.
	private static void dfs(int depth, int start) {
		if (depth == 2) {
			int sum = 0;
			for (int i = 0; i < candidate.length; i++) {
				sum += candidate[i];
			}

			if (sum == x) {
				pairCount++;
			}
		} else {
			for (int i = start; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					candidate[depth] = arr[i];
					dfs(depth + 1, i + 1);
					visited[i] = false;
				}
			}
		}
	}

}