import java.io.*;
import java.util.*;

public class BOJ_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder builder = new StringBuilder();

        int inputCount = Integer.parseInt(br.readLine());
        int input;
        int node;

        for (int i = 0; i < inputCount; i++) {
            input = Integer.parseInt(br.readLine());

            if(i % 2 == 0)
            {
                max.add(input);
            }
            else
            {
                min.add(input);
            }

            if(!min.isEmpty() && !max.isEmpty())
            {
                if (min.peek() < max.peek())
                {
                    node = min.poll();
                    min.offer(max.poll());
                    max.offer(node);
                }
            }
            builder.append(max.peek()+"\n");
        }
        System.out.println(builder);
    }
}