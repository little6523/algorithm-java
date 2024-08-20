// from collections import deque
// import sys

// if __name__ == "__main__" :
//     deq = deque()

//     N = int(input())
//     for _ in range(N) :
//         command = sys.stdin.readline().rstrip()

//         if "push" in command :
//             a, b = command.split()
//             deq.append(int(b))
//         elif "pop" in command :
//             if len(deq) == 0 :
//                 print(-1)
//             else :
//                 num_pop = deq.popleft()
//                 print(num_pop)
//         elif "size" in command :
//             print(len(deq))
//         elif "empty" in command :
//             if len(deq) == 0 :
//                 print(1)
//             else:
//                 print(0)
//         elif "front" in command :
//             if len(deq) == 0 :
//                 print(-1)
//             else :
//                 print(deq[0])
//         elif "back" in command:
//             if len(deq) == 0 : print(-1)
//             else : print(deq[-1])
