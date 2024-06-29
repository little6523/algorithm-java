import java.util.*;
import java.io.*;

class Top {
	int num;
	int height;

	public Top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}

public class Main {

	static int N;
	static Stack<Top> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());

			// 매 반복문마다 0이 붙는걸 방지함 맨처음에는 무조건 스택이 비어있으면서 가장 맨 앞은 비교할 대상이 없기 때문에 처리
			if (stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new Top(i + 1, height));
			} else {
				while (true) {
					// 2번째 기둥부터 처리하는데, 해당 분기문은 처리되는 도중에 만약 스택이 비어있는경우를 위해서 넣은 조건문
					if (stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new Top(i + 1, height));
						break;
					}

					Top current = stack.peek();

					if (current.height > height) {
						sb.append(current.num).append(" ");
						stack.push(new Top(i + 1, height));
						break;
					} else {
						// 여기에 온건 자기보다 앞에 더이상 큰 수가 없기 때문에 사실상 자기를 제외하고 스택을 날려도 됌
						// ex) 현재 스택의 최 상단이 6이고 current가 9일때 더 크고 어짜피 비교군이 없기 때문에 스택에 최상단을 날림
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}