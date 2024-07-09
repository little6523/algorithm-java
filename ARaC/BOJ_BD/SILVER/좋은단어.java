// import sys
// if __name__ == "__main__" :
//     N = int(input())
//     stack = []
//     answer = 0
//     for _ in range(N) :
//         words = sys.stdin.readline().rstrip()

//         for s in words :
//             if len(stack) == 0 :
//                 stack.append(s)

//             elif stack[-1] == s :
//                 stack.pop()
//             else :
//                 stack.append(s)
//             #print(stack)
//         if len(stack) == 0 :
//             answer += 1
//         stack.clear()

//     print(answer)
