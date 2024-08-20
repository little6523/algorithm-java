

// if __name__=="__main__" :
//     n = int(input())
//     lst = list(map(int, input().split(" ")))
//     k = int(input())

//     count = 0
//     #정렬
//     lst.sort()

//     # 투포인터
//     startPoint = 0
//     endPoint = n-1
//     while startPoint < endPoint :
//         if lst[startPoint] + lst[endPoint] < k :
//             startPoint += 1

//         elif lst[startPoint] + lst[endPoint] > k :
//             endPoint -= 1
//         else :
//             count += 1
//             endPoint -= 1
//     print(count)
