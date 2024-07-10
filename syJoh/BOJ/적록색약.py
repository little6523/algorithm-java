import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y, color):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    while q:
        curx, cury = q.popleft()
        for d in directions:
            nx, ny = curx+d[0], cury + d[1]
            if 0<=nx<n and 0<=ny<n and graph[nx][ny] == color and not visited[nx][ny]:
                q.append((nx, ny))
                visited[nx][ny] = True   
    
n = int(input())
directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
visited = [[False] * n for _ in range(n)]
graph = []
count = 0
for _ in range(n):
  row = list(input().strip())
  graph.append(row)
# 탐색
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'R' and not visited[i][j]:
            bfs(i, j, 'R')
            count += 1
        elif graph[i][j] == 'B' and not visited[i][j]:
            bfs(i, j, 'B')
            count += 1
        elif graph[i][j] == 'G' and not visited[i][j]:
            bfs(i, j, 'G')
            count += 1
result = []
result.append(count)
# R->G
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'R':
            graph[i][j] = 'G'
# 적록색약 탐색
visited = [[False] * n for _ in range(n)]
count = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'G' and not visited[i][j]:
            bfs(i, j, 'G')
            count += 1
        elif graph[i][j] == 'B' and not visited[i][j]:
            bfs(i, j, 'B')
            count += 1
result.append(count)

print(result[0], result[1])

"""
import java.io.*;
import java.util.*;

public class Main {
    static int n, count;
    static Character[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        graph = new Character[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j);
            }
        }
        //탐색
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    count++;
                }
                //녹색-> 적색
                if(graph[i][j] == 'G')
                    graph[i][j] = 'R';

            }
        }
        sb.append(count);
        //적록색약 탐색
        count = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        sb.append(" "+count);
        br.close();
        System.out.println(sb.toString());
    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q. offer(new int[]{x, y});
        visited[x][y] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                //범위 밖일 경우 skip
                if(nx<0 || nx>=n || ny<0 || ny>=n ) continue;
                //방문한 칸이거나 다른 영역일 때
                if(visited[nx][ny] || graph[nx][ny] != graph[cur[0]][cur[1]]) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

    }
}

"""
