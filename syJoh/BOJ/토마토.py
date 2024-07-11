import sys
from collections import deque

input = sys.stdin.readline
m, n, h = map(int, input().split())
graph = []
for _ in range(h):
    g = []
    for _ in range(n):
        g.append(list(map(int, input().split())))
    graph.append(g)
visited = [[[[False] for _ in range(m)] for _ in range(n)] for _ in range(h)]
directions = [(1, 0, 0), (0, 1, 0), (-1, 0, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)]
day = 0
q = deque()

def bfs():
    global day
    while q:
        cx, cy, cz = q.popleft()
        for d in directions:
            nx, ny, nz = cx + d[0], cy + d[1], cz + d[2]
            #인접한 좌표가 범위 안이고 아직 안 익은 상태 토마토인 경우
            if 0 <= nx < h and 0 <= ny < n and 0 <= nz < m and graph[nx][ny][nz] == 0:
                q.append((nx, ny, nz))
                #익은 토마토는 현재 일수+1
                graph[nx][ny][nz] = graph[cx][cy][cz] + 1
                day = graph[cx][cy][cz]

# 모두 익지 않은 상황인지 체크
def isGood():
    for i in range(h):
        for j in range(n):
            for k in range(m):
                if graph[i][j][k] == 0:
                    return False
    return True

# 익은 토마토 -> 큐(덱)
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k] == 1:
                q.append((i, j, k))
                visited[i][j][k] = True
# 탐색
bfs()
if isGood():
    print(day)
else:
    print(-1)
"""
import java.io.*;
import java.util.*;
import java.lang.*;
class Pos{
    int x;
    int y;
    int z;
    Pos(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static int m, n, h, day;
    static int[][][] graph;
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int[h][n][m]; //3차원 배열 (z, y, x)순으로 구현
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(graph[i][j][k]==1){
                        q.offer(new Pos(k, j, i));
                    }
                }
            }
        }
        bfs();
        br.close();
        if(isGood()){
            System.out.println(day);
        }else{
            System.out.println(-1);
        }
    }

    public static void bfs(){
        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
    
        while(!q.isEmpty()){
            Pos cur = q.poll(); //현 좌표
            for(int i=0; i<6; i++){ //인접한 방향 탐색
                int nx = cur.x +dx[i];
                int ny = cur.y +dy[i];
                int nz = cur.z +dz[i];

                //범위 밖이면 skip
                if(nx<0 || nx>=m || ny<0| ny>=n||nz<0||nz>=h) continue;
                //방문한 지역 || 토마토가 없으면 skip
                if(graph[nz][ny][nx] >=1||graph[nz][ny][nx]==-1) continue;
                //인접한 곳에 안 익은 토마토가 있을 경우
                if(graph[nz][ny][nx]==0){
                    day = graph[cur.z][cur.y][cur.x];
                    graph[nz][ny][nx] = graph[cur.z][cur.y][cur.x]+1;
                    q.offer(new Pos(nx, ny, nz));
                }
            }
        }
    }
    public static boolean isGood(){
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(graph[i][j][k]==0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

"""
