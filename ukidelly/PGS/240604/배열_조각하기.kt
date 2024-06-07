class Solution {

  /**
   * 제가 푼 방식
   */
  fun solution(arr: IntArray, query: IntArray): List<Int> {

    var list = arr.toList()

    query.forEach {
      list = if (it % 2 == 0) {
        list.slice(0..<it)
      } else {
        list.slice(it..<list.lastIndex)
      }
    }

    return list
  }

  // Java에서 푼 정답을 보고 Kotlin으로 적용한 방식
  fun solution2(arr: IntArray, query: IntArray): List<Int> {
    val arrList = arr.toList()

    var (startIndex, endIndex) = 0 to arrList.lastIndex

    for (q in query) {
      // q가 짝수일때, endIndex를 startIndex에서 q의 이전 인덱스로 지정 ( q를 포함해서 뒤 요소들을 버려야하므로 )
      if (q.isEven()) endIndex = startIndex + (q - 1)
      // q가 홀수 일때, startIndex를 q만큰 앞으로 이동 ( q를 포함해서 앞 요소들을 버려야하기 떄문 )
      else startIndex += q
    }
    
    return arrList.slice(startIndex..endIndex)
  }
}

// 짝수인지 홀수인지 판별하는 확장함수
fun Int.isEven() = this % 2 == 0