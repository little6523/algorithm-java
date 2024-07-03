import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i=1; i<=n; i++) {
            deque.offer(i);
        }

        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = 0;

            for(int j : deque) {
                if(j == num) {
                    break;
                } else {
                    index++;
                }
            }

            while(num != deque.peek()) {
                if(index <= (deque.size() / 2)) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                } else {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            deque.poll();
        }

        System.out.println(count);
    }
}
