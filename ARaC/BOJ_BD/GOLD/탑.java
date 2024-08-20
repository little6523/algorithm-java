// if __name__ == "__main__" :
//     N = int(input())
//     lst = list(map(int, input().split(" ")))
//     stack = [] # 결과를 출력할 리스트
//     stack.append((100000001,0))

//     for idx in range(N) :

//         while stack[-1][0] < lst[idx] :
//             stack.pop()

//         print(stack[-1][1], end= " ")
//         stack.append((lst[idx], idx + 1))
