class Solution {
  fun solution(arr: IntArray): IntArray {
    // Pair를 사용해서 start, end를 한번에 선언
    val (start, end) = arr.indexOfFirst { it == 2 } to arr.indexOfLast { it == 2 }

    // try catch과 같은 예외처리 함수인 runCatching를 사용하여 슬라이싱에 익셉션이 발생하면 [-1]을 반환하도록 처리
    return runCatching { arr.slice(start..end).toIntArray() }.getOrElse { intArrayOf(-1) }
  }
}