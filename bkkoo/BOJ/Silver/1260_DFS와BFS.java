import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {

    static int[][] tree;
    static boolean[] visited;
    static StringBuilder builder;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        builder = new StringBuilder();

        int node = sc.nextInt();
        int line = sc.nextInt();
        int startNode = sc.nextInt();

       tree = new int [node+1][node+1];


        for (int i = 1; i <= line; i++) {
            int first = sc.nextInt();
            int second  = sc.nextInt();

            tree[first][second] = tree[second][first] = 1;
        }

        visited = new boolean[node+1];
        DFS(startNode);
        builder.append("\n");

        visited = new boolean[node+1];
        BFS(startNode);

        System.out.println(builder);

    }

    public static void DFS(int start)
    {
        visited[start] = true;
        builder.append(start + " ");

        if(start == tree.length)
        {
            return;
        }

        for (int i = 0; i < tree[start].length; i++)
        {
            if(tree[start][i] == 1 && !visited[i])
            {
                DFS(i);
            }
        }
    }

    public static void BFS(int start)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty())
        {
            start = queue.poll();
            builder.append(start + " ");
            for (int i = 0; i < tree.length; i++)
            {
                if(tree[i][start] == 1 && !visited[i])
                {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
}
