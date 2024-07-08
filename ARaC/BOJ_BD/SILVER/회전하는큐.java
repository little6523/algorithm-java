// from collections import deque

// if __name__ == "__main__" :
//     deq_origin = deque()
//     N,M = map(int, input().split())

//     for num in range(1, N+1) :
//         deq_origin.append(num)
//     index_list = list(map(int, input().split()))
//     deq_copy = deq_origin.copy()
//     answer = 0
//     for index in index_list :
//         get_num = deq_origin[index-1]
//         while 1 :
//             if deq_copy[0] == get_num:
//                 deq_copy.popleft()
//                 break
//             elif deq_copy.index(get_num) <= (len(deq_copy) // 2):
//                 deq_copy.append(deq_copy[0])
//                 deq_copy.popleft()
//                 answer += 1
                
//             else :
//                 deq_copy.appendleft(deq_copy[-1])
//                 deq_copy.pop()
//                 answer += 1

//     print(answer)
