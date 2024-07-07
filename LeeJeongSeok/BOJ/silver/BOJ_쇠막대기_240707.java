import java.io.*;
import java.util.*;

public class Main {

	static int result;
	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pipe = br.readLine();

		for (int i = 0; i < pipe.length(); i++) {
			if (pipe.charAt(i) == '(') {
				stack.push('(');
			} else {
				stack.pop();

				if (pipe.charAt(i - 1) == '(') {
					result += stack.size();
				} else {
					result++;
				}
			}
		}

		System.out.println(result);
	}
}