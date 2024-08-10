N, C = map(int, input().split())
code = list(map(int, input().split()))

answer = []
answer_idx = 0
for idxc in range(len(code)) :
    if code[idxc] not in code[0:idxc] :
        answer.append((code[idxc],1))
        continue
    for idx in range(len(answer)) :
        if answer[idx][0] == code[idxc] :
            answer[idx] = (answer[idx][0], answer[idx][1]+1)
            break


answer.sort(key=lambda x:-x[1])

for num, counting in answer :
    for _ in range(counting) :
        print(num, end=" ")
