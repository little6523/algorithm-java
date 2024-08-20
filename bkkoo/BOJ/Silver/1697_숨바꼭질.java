import java.io.*;
import java.util.*;

public class BOJ_1697 {
    static int maxSize = 100001;
    static int[] map;
    static int[] dx = {-1, 0, 1};

    static int startPos;
    static int endPos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        startPos= Integer.parseInt(tokenizer.nextToken());
        endPos= Integer.parseInt(tokenizer.nextToken());

        map = new int[maxSize];
        Arrays.fill(map, -1);

        FindSister();
        System.out.println(map[endPos]);
    }

    static void FindSister()
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startPos);

        map[startPos] = 0;

        while (!queue.isEmpty())
        {
            int currentPos = queue.poll();
            if(currentPos == endPos)
            {
                break;
            }
            for (int i = 0; i < 3; i++) {
                //Set NextPos
                int nextPos;
                if(dx[i] == 0)
                {
                    nextPos = currentPos*2;
                }
                else
                {
                    nextPos = currentPos + dx[i];
                }

                //MoveCheck
                if(nextPos < 0 || nextPos >= maxSize)
                {
                    continue;
                }
                if(map[nextPos] != -1)
                {
                    continue;
                }

                queue.offer(nextPos);
                map[nextPos] = map[currentPos]+1;
            }

        }

    }
}
