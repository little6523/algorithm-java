import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		dfs(0);
	}

	private static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println("");
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result[depth] = arr[i];
					dfs(depth + 1);
					visited[i] = false;
				}
			}
		}
	}

}