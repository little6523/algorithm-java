import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
//        System.out.print(main.solution(a));
        System.out.print(main.solution(a, 0));
        br.close();
    }
//재귀풀이
    public int solution(int n, int count) {
        if(n<2) return count;
        int a = solution(n/2, count+1+(n%2)); //나누어떨어지지 않는 경우에는 무조건 -1연산만 가능하기 때문이다!
        int b = solution(n/3, count+1+(n%3));
        return Math.min(a, b);
    }
////dp풀이
//    public int solution(int a) {
//        int[] arr = new int[a + 1];
//
//        for (int i = 2; i <= a; i++) {
//            arr[i] = arr[i - 1] + 1;
//            if (i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
//            if (i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);
//        }
//        return arr[a];
//    }
////BFS풀이
//        public int solution(int a) {
//        Queue<Integer> q = new LinkedList<>();
//        int[] visited = new int[a + 1];
//        q.offer(1);
//        visited[1] = 0;
//        while (!q.isEmpty()) {
//            int cur = q.poll();
//            int[] tmp = {cur + 1, cur * 2, cur * 3};
//            for (int i : tmp) {
//                if (i <= a && visited[i] == 0) {
//                    visited[i] = visited[cur] + 1;
//                    if(i==a) return visited[i];
//                    q.offer(i);
//                }
//            }
//        }
//        return visited[a];
//  }
}
