import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int size;
    static int connection;
    static boolean[][] map;
    static boolean[] isInfected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        size = Integer.parseInt(br.readLine());
        connection = Integer.parseInt(br.readLine());

        map = new boolean[size][size];
        isInfected = new boolean[size];
        for (int i = 0; i < connection; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken()) - 1;
            int y = Integer.parseInt(tokenizer.nextToken()) - 1;
            map[x][y] = true;
            map[y][x] = true;
        }
        BFS(0);
    }

    static void BFS(int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isInfected[start] = true;
        int answer = 0;
        while (!queue.isEmpty())
        {
            int currentPosition = queue.poll();

            for (int i = 1; i < size; i++)
            {
                if(isInfected[i])
                {
                    continue;
                }
                if(!map[currentPosition][i])
                {
                    continue;
                }

                queue.offer(i);
                isInfected[i] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
