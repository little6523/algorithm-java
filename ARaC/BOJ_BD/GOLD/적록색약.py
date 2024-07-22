import sys
from collections import deque
def BFS(r,c) :
    # 상하좌우
    dc = [1, 0, -1, 0]
    dr = [0, 1, 0, -1]

    queue.append((r, c))
    visited[r][c] = 1

    while queue:
        nr, nc = queue.popleft()

        for dir in range(4):
            fr = nr + dr[dir]
            fc = nc + dc[dir]
            if 0<= fr <N and 0<= fc <N and not visited[fr][fc] and grid[fr][fc] == grid[nr][nc]:
                queue.append((fr, fc))
                visited[fr][fc] = 1

N = int(input())
grid = [list(input()) for _ in range(N)]
visited = [[0 for _ in range(N)] for _ in range(N)]

#값
usual = 0
unusual = 0
#적록색약이 아닌 경우
queue = deque()
for r in range(N) :
    for c in range(N) :
        if not visited[r][c] :
            BFS(r,c)
            usual+=1

#적록색약인 경우
for r in range(N) :
    for c in range(N) :
        if grid[r][c] == "G":
            grid[r][c] = "R"
visited = [[0 for _ in range(N)] for _ in range(N)]
for r in range(N) :
    for c in range(N) :
        if not visited[r][c] :
            BFS(r,c)
            unusual+=1


print(usual, unusual)
