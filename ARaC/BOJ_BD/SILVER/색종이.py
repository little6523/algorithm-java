canvas = [[0 for _ in range(101)] for _ in range(101)] #캔버스

N = int(input())

for _ in range(N) :
    x, y = map(int, input().split())
    for idx in range(x, x+10) :
        for idy in range(y, y+10) :
            canvas[idx][idy] = 1

answer = 0
for i in canvas :
    answer += i.count(1)
print(answer)
