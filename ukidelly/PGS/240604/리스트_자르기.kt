/**
 * 제가 푼 방식
 */
class Solution {
  fun solution(n: Int, slicer: IntArray, numList: IntArray): IntArray {
    return when (n) {
      1 -> {
        val end = slicer[1]
        numList.slice(0..end).toIntArray()
      }
      
      // 잉... 버전 또는 jdk 이슈인지 모르겠지만 .. 연산자를 쓰면 오류가 발생해서 함수명을 사용했는데
      // 왜 다른 분들은 정상적으로 연산자를 사용하는거죠?? ㅠㅠ
      2 -> numList.slice(slicer[0] until numList.size).toIntArray()
      3 -> numList.slice(slicer[0].rangeTo(slicer[1])).toIntArray()
      4 -> numList.slice(slicer[0].rangeTo(slicer[1]) step slicer[2]).toIntArray()
      else -> intArrayOf()
    }
  }
}

/**
 * 인상 깊었던 방식
 */
class Solution {
    fun solution(n: Int, slicer: IntArray, numList: IntArray): IntArray {
        // null을 반환할때 까지 각 다음 값에 연산을 적용하여 시퀀스를 생성
        return generateSequence(
            // 다음 값에 적용하는 로직
            if (n == 1) 0 else slicer[0],
            { it + if (n == 4) slicer[2] else 1 }
        )
            .takeWhile { it <= if (n == 2) numList.size - 1 else slicer[1] }
            .map { numList[it] }
            .toList()
            .toIntArray()
    }
}

/**
 * 인상 깊었던 방식2
 */
class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray {
        // 패턴 매칭을 활용해서 slicer에서 abc 값을 추출
        val (a,b,c) = slicer

        return when (n) {
            1 -> num_list.slice(0..b)
            2 -> num_list.slice(a..num_list.lastIndex)
            3 -> num_list.slice(a..b)
            // 4를 else로 처리
            else -> (a..b step c).map { num_list[it] }
        }.toIntArray()
    }
}