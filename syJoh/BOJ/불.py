# 메모리 : 114608 KB 시간 : 1996ms	
import sys
from collections import deque
input = sys.stdin.readline
direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]

def bfs():
    while fireq:
        cx, cy = fireq.popleft()
        for d in direction:
            nx, ny = cx+d[0], cy+d[1]
            if 0<=nx<h and 0<=ny<w and fireVis[nx][ny] == -1 and graph[nx][ny]!='#':
                fireVis[nx][ny] = fireVis[cx][cy]+1
                fireq.append((nx, ny))
    while q:
        cx, cy = q.popleft()
        for d in direction:
            nx, ny = cx + d[0], cy + d[1]
            # 범위 밖 = 탈출
            if nx<0 or nx>=h or ny<0 or ny>=w:
                return sgVis[cx][cy]+1
            # 상근이가 이미 지나왔거나 벽인 경우 skip
            if sgVis[nx][ny] != -1 or graph[nx][ny] == '#':
                continue
            # 불이 번져있고 상근이 도착시간 전에 불 날 경우 skip
            if fireVis[nx][ny] != -1 and fireVis[nx][ny] <= sgVis[cx][cy]+1 :
                continue
            # 상근 이동
            sgVis[nx][ny] = sgVis[cx][cy]+1
            q.append((nx, ny))
    return "IMPOSSIBLE"

t = int(input().strip())
global w, h, fireq, q, fireVis, sgVis
for _ in range(t):
    w, h = map(int, input().strip().split())
    graph = []
    fireVis = [[-1] * w for _ in range(h)]
    sgVis = [[-1] * w for _ in range(h)]
    q = deque()
    fireq = deque()
    for i in range(h):
        graph.append(list(input().strip()))
        for j in range(w):
            if graph[i][j] == '*':
                fireq.append((i, j))
                fireVis[i][j] = 0
            elif graph[i][j] == '@':
                q.append((i, j))
                sgVis[i][j] = 0

    print(bfs())
"""
# [기존 풀이]메모리 : 115584 KB 시간 : 2004ms	
import sys
from collections import deque
input = sys.stdin.readline
direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]

# 불 탐색
def fireBfs(w, h):
    global graph, fireVis
    q = deque()
    for i in range(h):
        for j in range(w):
            if graph[i][j] == '*':
                q.append((i, j))
                fireVis[i][j] = 0  # 시작점의 시간을 0으로 설정
    while q:
        cx, cy = q.popleft()
        for d in direction:
            nx, ny = cx + d[0], cy + d[1]
            #범위 안이고, 그래프가 벽이 아니면서 방문한 경험이 없으면 불 번짐
            if 0 <= nx < h and 0 <= ny < w and graph[nx][ny] != '#' and fireVis[nx][ny] == -1:
                fireVis[nx][ny] = fireVis[cx][cy] + 1
                q.append((nx, ny))

# 상근 탐색
def sgBfs(x, y, w, h):
    global graph, fireVis, sgVis
    q = deque()
    q.append((x, y))
    sgVis[x][y] = 0  # 시작점의 시간을 0으로 설정
    while q:
        cx, cy = q.popleft()
        for d in direction:
            nx, ny = cx + d[0], cy + d[1]
            # 범위 밖 = 탈출
            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                return sgVis[cx][cy] + 1
            # 인접좌표가 벽이 아니고, 방문한 적 없고, 불이 아직 안 나거나 불이 난 시간보다 적을 때
            if graph[nx][ny] != '#' and sgVis[nx][ny] == -1 and (
                    fireVis[nx][ny] == -1 or sgVis[cx][cy] + 1 < fireVis[nx][ny]):
                sgVis[nx][ny] = sgVis[cx][cy] + 1
                q.append((nx, ny))
    return 'IMPOSSIBLE'

t = int(input().strip())
for _ in range(t):
    w, h = map(int, input().strip().split())
    graph = []
    fireVis = [[-1] * w for _ in range(h)]
    sgVis = [[-1] * w for _ in range(h)]
    start_x = start_y = -1
    for i in range(h):
        graph.append(list(input().strip()))
        for j in range(w):
            if graph[i][j] == '@':
                start_x, start_y = i, j

    fireBfs(w, h)
    print(sgBfs(start_x, start_y, w, h))
"""
