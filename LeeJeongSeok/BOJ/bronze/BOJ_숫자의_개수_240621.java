import java.io.*;

public class Main {

	static int[] arr = new int[3];
	static int[] sequence = new int[10];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int total = 1;
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total *= arr[i];
		}

		String temp = String.valueOf(total);

		for (int i = 0; i < temp.length(); i++) {
			int index = Integer.parseInt(String.valueOf(temp.charAt(i)));
			sequence[index]++;
		}

		for (int i = 0; i < sequence.length; i++) {
			sb.append(sequence[i]).append("\n");
		}

		System.out.println(sb.toString());
	}

}