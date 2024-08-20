from collections import deque

def reversing(reversedNum) :

    for i in range(len(reversedNum)):
        if reversedNum[i] != '0':
            startIdx = i
            break
    return startIdx
answer = []
#첫째 줄을 입력받아 n을 구한다
n = 0
lst = list(input().split())
n = int(lst[0])
del lst[0]

#원소를 리스트로 받는다
while len(lst) < n :
    lst.extend(list(input().split()))

for str in lst :
    startIdx = 0
    reversedNum = str[::-1]
    startIdx = reversing(reversedNum)
    answer.append(int(reversedNum[startIdx:]))

answer.sort()
for a in answer :
    print(a)
