import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer con = new StringTokenizer(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(con.nextToken());
        int m = Integer.parseInt(con.nextToken());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.print(solution(n, arr));

        br.close();
    }

    private static int solution(int n, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        int result = 0;
        for (int a : arr) {
            int cnt = 0;
            while(deque.contains(a)) {
                if(deque.peekFirst()==a){
                    deque.pollFirst();
                }
                else{
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
            }
            result += Math.min(cnt, deque.size()-cnt+1);
        }
        return result;
    }
}
