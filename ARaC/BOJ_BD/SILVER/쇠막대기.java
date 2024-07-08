// import sys

// if __name__ == "__main__" :
//     batch = sys.stdin.readline().rstrip()
//     length = len(batch)
//     stack = []
//     answer = 0
//     for idx in range(length) :
//         if batch[idx] == "(" :
//             stack.append(batch[idx])
//         elif batch[idx] == ")" and batch[idx-1] == "(" : #레이저 "()"
//             stack.pop()
//             answer += len(stack)
//         elif batch[idx] == ")" and batch[idx-1] == ")" :
//             stack.pop()
//             answer += 1

//     print(answer)
