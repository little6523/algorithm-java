import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
    //k번째 숫자 찾기
		List<Integer> list = new ArrayList<>();
		int idx = 0;
		while(!q.isEmpty()) {
			idx++;
			if(idx==k) {
				list.add(q.poll());
				idx = 0;
			}else {
				q.offer(q.poll());
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0; i<list.size()-1; i++) {
			sb.append(list.get(i)+", ");
		}
		sb.append(list.get(list.size()-1)+">");
		br.close();
		System.out.print(sb);

	}

}
