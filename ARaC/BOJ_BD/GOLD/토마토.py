from collections import deque

def BFS() :

    while que:
        h, r, c = que.popleft()
        # 한 층에 상하좌우 체크
        for dir in range(6):
            nextH = h + nh[dir]
            nextR = r + nr[dir]
            nextC = c + nc[dir]
            if 0<=nextH<height and 0<= nextR < row and 0<= nextC < col and not visited[nextH][nextR][nextC] and box[nextH][nextR][nextC] == 0 :
                que.append((nextH, nextR, nextC))
                #box 영역에 숫자 +1(걸린시간 알아보기위함), visited는 true로 사용
                box[nextH][nextR][nextC] = box[h][r][c] +1
                #print(box[nextH][nextR][nextC])
                visited[nextH][nextR][nextC] = 1

col, row, height = map(int, input().split())
box =[]
for _ in range(height) :
    box.append([list(map(int, input().split())) for _ in range(row)])
#방문 체크
visited = [[[0 for _ in range(col)] for _ in range(row)] for _ in range(height)]
#상하좌우 위아래
nh = [0,0,0,0,1,-1]
nc = [1,0,-1,0,0,0]
nr = [0,1,0,-1,0,0]

que = deque()
for idxH in range(height) :
    for idxR in range(row) :
        for idxC in range(col) :
            #익은 토마토(1)를 모두 큐에 넣는다
            if box[idxH][idxR][idxC] == 1 and not visited[idxH][idxR][idxC]  :
                que.append((idxH,idxR,idxC))
                visited[idxH][idxR][idxC] = 1
                
BFS()

answer = 0

# for boxHeight in range(height) :
#     for boxRow in range(row) :
#         if 0 in box[boxHeight][boxRow] :
#             print(-1)
#             exit()
#     answer = (max(map(max, list(map(max, box))))-1)
for a in box:
    for b in a:
        for c in b:
            if c == 0:
                print(-1)
                exit(0)
        answer = max(answer, max(b))

print(answer-1)
