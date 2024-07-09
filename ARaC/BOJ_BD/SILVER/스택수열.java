// if __name__=="__main__" :
//     k = int(input())
//     result = []

//     for _ in range(k) :
//         num = int(input())
//         result.append(num)

//     idx = 0
//     stack = []
//     answer = []

//     stack_input = 1
//     while idx < k :
//         if len(stack) == 0 or stack[-1] < result[idx] : #push할 경우
//             stack.append(stack_input)
//             stack_input += 1
//             answer.append("+")
//             continue
//         elif stack[-1] > result[idx] :
//             answer.append("NO")
//             break
//         elif stack[-1] == result[idx] : #pop할 경우
//             stack.pop()
//             idx += 1
//             answer.append("-")
//     if answer[-1] == "NO" :
//         print("NO")
//     else :
//         for s in answer :
//             print(s)




