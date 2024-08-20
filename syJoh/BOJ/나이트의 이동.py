import sys
from collections import deque
input = sys.stdin.readline
directions = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

def bfs(curx, cury, desx, desy):
    q = deque()
    q.append((curx, cury))
    graph[curx][cury] += 1
    visited[curx][cury] = True
    
    while q:
        x, y = q.popleft()
        for d in directions:
            nx, ny = x+d[0], y+d[1]
            # 인접 좌표가 목적지 좌표와 같을 때
            if nx==desx and ny==desy:
                return graph[x][y]
            if 0<=nx<i and 0<=ny<i and not visited[nx][ny]:
                q.append((nx, ny))
                graph[nx][ny] = graph[x][y]+1
                visited[nx][ny] = True
    return 0

tc = int(input().strip())
for _ in range(tc):
    i = int(input().strip())
    graph = [[0]*i for _ in range(i)]
    visited = [[False]*i for _ in range(i)]
    curx, cury = map(int, input().strip().split())
    desx, desy = map(int, input().strip().split())
    if curx==desx and cury==desy:
      print(0)
    else:
      print(bfs(curx, cury, desx, desy))
"""
import java.util.*;
import java.io.*;

class Pos{
    int x;
    int y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int i;
    static int desx, desy; //목적지 좌표
    static int[][] graph;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            i = Integer.parseInt(br.readLine());
            graph = new int[i][i];
            visited = new boolean[i][i];
            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            desx = Integer.parseInt(st.nextToken());
            desy = Integer.parseInt(st.nextToken());
            //출발지 = 목적지인 경우
            if((cx==desx) && (cy==desy)){
                sb.append(0).append("\n");
            }else{
                sb.append(bfs(cx, cy)).append("\n");
            }
            t--;
        }
        br.close();
        System.out.print(sb.toString());
    }
    static int bfs(int cx, int cy){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(cx, cy));
        graph[cx][cy]++;
        visited[cx][cy] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();
            for(int idx=0; idx<8; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                //인접 좌표가 목표 좌표와 같을 경우 탐색 중단
                if(nx==desx && ny==desy){
                    return graph[cur.x][cur.y];
                }
                //인접 좌표가 범위 안에 있고, 방문한 적 없는 경우
                if(nx>=0 && nx<i && ny>=0 && ny<i && !visited[nx][ny]){
                    q.offer(new Pos(nx, ny));
                    graph[nx][ny] = graph[cur.x][cur.y]+1;
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }
}
"""
