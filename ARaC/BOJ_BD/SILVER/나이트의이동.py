from collections import deque

def BFS() :
    answer = 0
    while que :
        r, c = que.popleft()

        for dir in range(8) :
            nextR = r + nr[dir]
            nextC = c + nc[dir]
            if 0<= nextR < l and 0<= nextC < l and not visited[nextR][nextC]:
                que.append((nextR,nextC))

                visited[nextR][nextC] = visited[r][c] + 1
                if nextR == endR and nextC == endC :
                    answer = visited[nextR][nextC]-1
                    que.clear()
    print(answer)

nr =[-2,-1,1,2,2,1,-1,-2]
nc =[1,2,2,1,-1,-2,-2,-1]
testCase = int(input())
for _ in range(testCase) :
    l = int(input())
    chess = [[0 for _ in range(l)] for _ in range(l)]
    visited = [[0 for _ in range(l)] for _ in range(l)]
    #시작점은 1로 한다
    startR, startC = map(int, input().split())
    chess[startR][startC] = 1
    visited[startR][startC] = 1
    #도착지점은 -1로 한다
    endR, endC = map(int, input().split())
    chess[endR][endC] = -1


    que = deque()
    #시작 체스판 좌표를 큐에 넣는다
    que.append((startR,startC))
    visited[startR][startC] = 1

    BFS()
