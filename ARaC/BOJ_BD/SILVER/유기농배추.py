from collections import deque

if __name__ == "__main__" :
    nr = [0,1,0,-1]
    nc = [1,0,-1,0]
    testCase = int(input())
    for _ in range(testCase) :
        row, col, pos = map(int, input().split(" "))
        farm = [[0 for _ in range(col)] for _ in range(row)]
        visited = [[0 for _ in range(col)] for _ in range(row)]
        queue = deque()
        cabbage = []

        for _ in range(pos) :
            tmpR, tmpC = map(int, input().split())
            cabbage.append((tmpR, tmpC))
            farm[tmpR][tmpC]=1

        answer = 0

        #BFS
        for r,c in cabbage :

            if visited[r][c] == 1 :
                continue

            queue.append((r,c))
            visited[r][c] = 1
            while queue:
                cabbageR, cabbageC = queue.popleft()

                for dir in range(4):
                    nextC= cabbageC + nc[dir]
                    nextR= cabbageR + nr[dir]
                    if 0 > nextC or nextC >= col or 0 > nextR or nextR >= row or visited[nextR][nextC] == 1 :
                        continue

                    if farm[nextR][nextC] == 1 and visited[nextR][nextC] == 0:
                        queue.append((nextR, nextC))
                        visited[nextR][nextC] = 1

            answer += 1

        print(answer)
