import sys
input = sys.stdin.readline
n, m = map(int, input().split())
a = list(map(int, input().split()))
for _ in range(m):
    i, j, k = map(int, input().split())
    tmp = a[i-1:j]
    tmp.sort()
    print(tmp[k-1])
