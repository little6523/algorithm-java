import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(T.solution(n));
    }

    public int solution(int n) {
        Queue<Integer> q = new LinkedList<>();
        int answer= 1;
        for(int i=1; i<=n; i++){
            q.offer(i);
        }

        while(q.size()>1){
            q.poll();
            answer = q.poll();
            q.offer(answer);
        }
        return answer;
    }
}

